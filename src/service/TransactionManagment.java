package service;

import entity.BankAccount;

public class TransactionManagment {
    public void deposit(BankAccount account, double amount) {
        account.deposit(amount);
    }

    public void withdraw(BankAccount account, double amount) {
        account.withdraw(amount);
    }

    public void printBalance(BankAccount account) {
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Balance: " + account.getAccountBalance());


    }
}
