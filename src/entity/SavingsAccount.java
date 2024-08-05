package entity;

public class SavingsAccount extends BankAccount{
    private double interestRate;

    public SavingsAccount(long accountNumber, double accountBalance, double interestRate) {
        super(accountNumber, accountBalance);
        this.interestRate = interestRate;
    }
    @Override
    public void deposit(double amount) {
        accountBalance += amount;
    }
    @Override
    public void withdraw(double amount) {
        if (accountBalance >= amount) {
            accountBalance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }
    public void addInterest() {
        accountBalance += accountBalance * interestRate;
    }
}
