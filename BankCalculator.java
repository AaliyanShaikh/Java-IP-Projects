import java.util.Scanner;

public class BankCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. EMI Calculator");
        System.out.println("2. Loan Eligibility Calculator");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.print("Enter loan amount: ");
            double amount = sc.nextDouble();

            System.out.print("Enter annual interest rate: ");
            double rate = sc.nextDouble();

            System.out.print("Enter loan duration in years: ");
            int years = sc.nextInt();

            if (amount <= 0 || rate < 0 || years <= 0) {
                System.out.println("Please enter valid values.");
            } else {
                int months = years * 12;
                double monthlyRate = rate / 1200;
                double emi;

                if (monthlyRate == 0) {
                    emi = amount / months;
                } else {
                    double power = Math.pow(1 + monthlyRate, months);
                    emi = amount * monthlyRate * power / (power - 1);
                }

                double totalAmount = emi * months;
                double interest = totalAmount - amount;

                System.out.printf("Monthly EMI: Rs. %.2f%n", emi);
                System.out.printf("Total Interest: Rs. %.2f%n", interest);
                System.out.printf("Total Amount Payable: Rs. %.2f%n", totalAmount);
            }

        } else if (choice == 2) {
            sc.nextLine();

            System.out.print("Enter your name: ");
            String name = sc.nextLine();

            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            System.out.print("Enter your monthly income: ");
            double income = sc.nextDouble();

            System.out.print("Enter your existing monthly EMI: ");
            double existingEMI = sc.nextDouble();

            System.out.print("Enter your credit score: ");
            int creditScore = sc.nextInt();

            System.out.print("Enter required loan amount: ");
            double loanAmount = sc.nextDouble();

            if (loanAmount <= 0) {
                System.out.println("Please enter a valid loan amount.");
            } else if (age < 21 || age > 60) {
                System.out.println("Sorry " + name + ", you are not eligible.");
                System.out.println("Reason: Age criteria not satisfied.");
            } else if (income < 15000) {
                System.out.println("Sorry " + name + ", you are not eligible.");
                System.out.println("Reason: Minimum income criteria not satisfied.");
            } else if (creditScore < 650) {
                System.out.println("Sorry " + name + ", you are not eligible.");
                System.out.println("Reason: Credit score is too low.");
            } else if (existingEMI < 0 || existingEMI > income * 0.4) {
                System.out.println("Sorry " + name + ", you are not eligible.");
                System.out.println("Reason: Existing EMI is too high or invalid.");
            } else {
                System.out.println("Congratulations " + name + "!");
                System.out.println("You meet the basic loan eligibility criteria.");
                System.out.println("Requested Loan Amount: Rs. " + loanAmount);
            }

        } else {
            System.out.println("Invalid choice.");
        }

        sc.close();
    }
}


