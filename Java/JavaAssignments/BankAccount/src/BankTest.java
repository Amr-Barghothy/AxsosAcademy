public class BankTest {
    public static void main(String[] args){
        // Create 3 bank accounts
        BankAccount acc1 = new BankAccount(10,20);
        BankAccount acc2 = new BankAccount(30,43);
        BankAccount acc3 = new BankAccount(80,19);
        // Deposit Test
        // - deposit some money into each bank account's checking or savings account and display the balance each time
        // - each deposit should increase the amount of totalMoney
        acc1.deposit(50,"checking");
        System.out.println(BankAccount.getTotalMoney());
        acc2.deposit(100,"saving");
        System.out.println(BankAccount.getTotalMoney());
        acc3.deposit(20,"checking");
        System.out.println(BankAccount.getTotalMoney());

        // Withdrawal Test
        // - withdraw some money from each bank account's checking or savings account and display the remaining balance
        // - each withdrawal should decrease the amount of totalMoney
        acc1.withdraw(10,"saving");
        System.out.println(BankAccount.getTotalMoney());
        acc2.withdraw(30,"checking");
        System.out.println(BankAccount.getTotalMoney());
        acc3.withdraw(80,"saving");
        System.out.println(BankAccount.getTotalMoney());


        // Static Test (print the number of bank accounts and the totalMoney)
        System.out.println(BankAccount.getAccounts());
        System.out.println(acc1.getBankAccountNUmber());
        System.out.println(acc2.getBankAccountNUmber());
        System.out.println(acc3.getBankAccountNUmber());
    }
}