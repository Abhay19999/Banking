package entity;

import javax.management.RuntimeMBeanException;
import java.util.Collections;

public class SavingsAccount extends BankAccount{
    private double interestRate;



    public SavingsAccount(long accountNumber, String accountHolderName, long primaryPhoneNumber,
                          String addressLine1, String city, String state, double accountBalance) {
        super(accountNumber, accountHolderName, primaryPhoneNumber, addressLine1, city, state, accountBalance);
    }


    @Override
    public void deposit(double dptAmount) {
            if(dptAmount<=0 ) {
                throw new RuntimeException("You cant deposit the Zero(0) or negative amount..");
            }else {
                accountBalance = accountBalance + dptAmount;
            }
        }
    @Override
    public double withdraw(double withAmount) {
        if(withAmount<=0) {
            throw new RuntimeException("You cant withdraw zero(0) or Negative Amount.");
        }else if(withAmount>accountBalance) {
            throw new RuntimeException("You don't have sufficient balance to withdraw. Please check your balance");
        }else {
            accountBalance = accountBalance - withAmount;
            return withAmount;
        }
    }
    public void addInterest() {
        accountBalance += accountBalance * interestRate;
    }

}
