package entity;

import service.IBasicAccountServices;

public  class BankAccount implements IBasicAccountServices {
    private long accountNumber;
    private String accountHolderName;
    private long primaryPhoneNumber;
    private String addressLine1;
    private String city;
    private String state;
    protected double accountBalance;



    //Parameterized Constructor
    public BankAccount(long accountNumber, String accountHolderName,
                       long primaryPhoneNumber, String addressLine1, String city,
                       String state, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.primaryPhoneNumber = primaryPhoneNumber;
        this.addressLine1 = addressLine1;
        this.city = city;
        this.state = state;
        this.accountBalance = accountBalance;
    }


    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public long getPrimaryPhoneNumber() {
        return primaryPhoneNumber;
    }

    public void setPrimaryPhoneNumber(long primaryPhoneNumber) {
        this.primaryPhoneNumber = primaryPhoneNumber;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void displayBankInfo() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder Name : " +  accountHolderName);
        System.out.println("Account Balance : " + accountBalance);
        System.out.println("Phone Number: " +  primaryPhoneNumber);
        System.out.println("Address: " + addressLine1);
        System.out.println("City: " + city);
        System.out.println("State: " + state);

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

    @Override
    public void deposit(double dptAmount) {
        if(dptAmount<=0 ) {
            throw new RuntimeException("You cant deposit the Zero(0) or negative amount..");
        }else {
            accountBalance = accountBalance + dptAmount;
        }
    }
}
