import java.util.Scanner;

public class LoanEligibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Loan Eligibility Calculator");

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

        System.out.print("Enter the required loan amount: ");
        double loanAmount = sc.nextDouble();

        System.out.println("\nLoan Eligibility Result");

        if (age < 21 || age > 60) {
            System.out.println("Sorry " + name + ", you are not eligible.");
            System.out.println("Reason: Age criteria not satisfied.");
        } else if (income < 15000) {
            System.out.println("Sorry " + name + ", you are not eligible.");
            System.out.println("Reason: Minimum income criteria not satisfied.");
        } else if (creditScore < 650) {
            System.out.println("Sorry " + name + ", you are not eligible.");
            System.out.println("Reason: Credit score is too low.");
        } else if (existingEMI > income * 0.4) {
            System.out.println("Sorry " + name + ", you are not eligible.");
            System.out.println("Reason: Existing EMI is too high.");
        } else if (loanAmount <= 0) {
            System.out.println("Please enter a valid loan amount.");
        } else {
            System.out.println("Congratulations " + name + ", you meet the basic eligibility criteria.");
            System.out.println("Requested Loan Amount: Rs. " + loanAmount);
        }

        sc.close();
    }
}
