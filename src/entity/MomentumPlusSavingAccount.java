package entity;

import java.util.ArrayList;

public class MomentumPlusSavingAccount extends SavingsAccount {
    private double bonusInterestRate;
    private ArrayList<String> transactionHistory;
    private double minimumBalance;
    private double monthlyFee;
    private double tieredInterestRate;



    public MomentumPlusSavingAccount(long accountNumber, String accountHolderName, long primaryPhoneNumber,
                                     String addressLine1, String city, String state, double accountBalance,
                                     double bonusInterestRate,
                                     double minimumBalance, double monthlyFee, double tieredInterestRate) {
        super(accountNumber, accountHolderName, primaryPhoneNumber, addressLine1, city, state, accountBalance);
        this.bonusInterestRate = bonusInterestRate;
        this.minimumBalance = minimumBalance;
        this.monthlyFee = monthlyFee;
        this.tieredInterestRate = tieredInterestRate;
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        transactionHistory.add("Deposit: $" + amount + ", New balance: $" + accountBalance);
    }

    @Override
    public double withdraw(double withAmount) {
        if (withAmount <= 0) {
            throw new RuntimeException("You cant withdraw zero(0) or Negative Amount.");
        } else if (withAmount > accountBalance) {
            throw new RuntimeException("You don't have sufficient balance to withdraw. Please check your balance");
        } else {
            accountBalance = accountBalance - withAmount;
            return withAmount;
        }
    }

        public void applyMonthlyFee () {
            if (accountBalance >= monthlyFee) {
                accountBalance -= monthlyFee;
                transactionHistory.add("Monthly fee applied: $" + monthlyFee + ", New balance: $" + accountBalance);
            } else {
                System.out.println("Insufficient balance to apply monthly fee.");
            }
        }

        public void printTransactionHistory () {
            System.out.println("Transaction History:");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }

        // Getters and Setters
        public double getBonusInterestRate () {
            return bonusInterestRate;
        }

        public void setBonusInterestRate ( double bonusInterestRate){
            this.bonusInterestRate = bonusInterestRate;
        }

        public double getMinimumBalance () {
            return minimumBalance;
        }

        public void setMinimumBalance ( double minimumBalance){
            this.minimumBalance = minimumBalance;
        }

        public double getMonthlyFee () {
            return monthlyFee;
        }

        public void setMonthlyFee ( double monthlyFee){
            this.monthlyFee = monthlyFee;
        }

        public double getTieredInterestRate () {
            return tieredInterestRate;
        }

        public void setTieredInterestRate ( double tieredInterestRate){
            this.tieredInterestRate = tieredInterestRate;
        }

    @Override
    public void addInterest() {
        super.addInterest();
        double interestRateToApply = accountBalance >= 5000 ? tieredInterestRate : getInterestRate();
            double interestAdded = accountBalance * (interestRateToApply + bonusInterestRate);
            accountBalance += interestAdded;
            transactionHistory.add("Interest added: $" + interestAdded + ", New balance: $" + accountBalance);
    }

}