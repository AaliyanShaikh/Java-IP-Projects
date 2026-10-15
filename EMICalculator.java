import java.util.Scanner;

public class EMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("EMI Calculator");

        System.out.print("Enter loan amount: ");
        double amount = sc.nextDouble();

        System.out.print("Enter annual interest rate (%): ");
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

            System.out.printf("%nMonthly EMI: Rs. %.2f%n", emi);
            System.out.printf("Total Interest: Rs. %.2f%n", interest);
            System.out.printf("Total Amount Payable: Rs. %.2f%n", totalAmount);
        }

        sc.close();
    }

}

