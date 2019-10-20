package SavingsAccount;

public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public void setAnnualInterestRate(double newValue) {
        annualInterestRate = newValue;
    }

    public void setSavingsBalance(double newValue) {
        savingsBalance = newValue;
    }

    public void printBalance() {
        System.out.println("Savings balance is " + savingsBalance);
    }
    public void calculateMonthlyInterest() {
        savingsBalance = savingsBalance + (savingsBalance * (annualInterestRate / 12.0));
    }

    public static void modifyInterestRate(double newValue) {
        annualInterestRate = newValue;
    }
}
