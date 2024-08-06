package entity;

public class SavingsAcceleratorAccount extends SavingsAccount{
    private double interestRate;
    private double minimumBalance;
    //    private ArrayList<String> transactionHistory;
    private double monthlyFee;
    private double tieredInterestRate;

    public SavingsAcceleratorAccount(long accountNumber, String accountHolderName, long primaryPhoneNumber,
                                     String addressLine1, String city, String state, double accountBalance,
                                     double interestRate, double minimumBalance, double monthlyFee,
                                     double tieredInterestRate) {
        super(accountNumber, accountHolderName, primaryPhoneNumber, addressLine1, city, state, accountBalance);
        this.interestRate = interestRate;
        this.minimumBalance = minimumBalance;
        this.monthlyFee = monthlyFee;
        this.tieredInterestRate = tieredInterestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }


    public double getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public double getTieredInterestRate() {
        return tieredInterestRate;
    }

    public void setTieredInterestRate(double tieredInterestRate) {
        this.tieredInterestRate = tieredInterestRate;
    }

    @Override
    public void addInterest() {
        super.addInterest();
    }

    @Override
    public double withdraw(double amount) {
        super.withdraw(amount);
        return amount;
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
    }

    @Override
    public void displayBankInfo() {
        System.out.println("Saving accelerator Account");
        super.displayBankInfo();
        System.out.println("Interest Rate: " + interestRate);
        System.out.println("Minimum Balance: " + minimumBalance);
        System.out.println("Monthly fee: " + monthlyFee);
        System.out.println("Tiered Interest Rate: " + tieredInterestRate);

    }
}
