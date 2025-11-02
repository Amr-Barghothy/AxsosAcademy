public class BankAccount {
    private static int accounts;
    private static double totalMoney; // refers to the sum of all bank account checking and savings balances
    // MEMBER VARIABLES
    private double checkingBalance;
    private double savingsBalance;

    // CONSTRUCTOR
    // Be sure to increment the number of accounts

    public BankAccount(double savingsBalance, double checkingBalance) {
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        accounts++;
    }

    // GETTERS
    // for checking, savings, accounts, and totalMoney

    public static int getAccounts() {
        return accounts;
    }

    public static double getTotalMoney() {
        return totalMoney;
    }

    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    // METHODS
    // deposit
    // - users should be able to deposit money into their checking or savings account
    public void deposit(double amount, String accountType) {
        if (accountType.equals("checking"))
            this.checkingBalance += amount;
        else
            this.savingsBalance += amount;
        totalMoney += amount;
    }

    // withdraw
    // - users should be able to withdraw money from their checking or savings account
    // - do not allow them to withdraw money if there are insufficient funds
    // - all deposits and withdrawals should affect totalMoney
    public void withdraw(double amount, String accountType) {
        if (accountType.equals("checking")) {
            if (!(this.checkingBalance - amount < 0))
                this.checkingBalance -= amount;
            else
                System.out.println("Insufficient balance");
        } else if (!(this.savingsBalance - amount < 0))
            this.savingsBalance -= amount;
        else
            System.out.println("Insufficient balance");
        if (!(totalMoney - amount < 0))
            totalMoney -= amount;
    }
    // getBalance
    // - display total balance for checking and savings of a particular bank account
    public double getBalance() {
        return this.checkingBalance + this.savingsBalance;
    }
}