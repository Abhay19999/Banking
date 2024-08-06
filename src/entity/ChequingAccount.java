package entity;

public class ChequingAccount extends BankAccount {

    private double overDraftLimit;


    public ChequingAccount(long accountNumber, String accountHolderName,
                           long primaryPhoneNumber, String addressLine1,
                           String city, String state, double accountBalance,
                           double overDraftLimit) {
        super(accountNumber, accountHolderName, primaryPhoneNumber, addressLine1, city, state, accountBalance);
        this.overDraftLimit = overDraftLimit;
    }

    public double getOverDraftLimit() {
        return overDraftLimit;
    }

    public void setOverDraftLimit(double overDraftLimit) {
        this.overDraftLimit = overDraftLimit;
    }

    @Override
    public void displayBankInfo() {
        super.displayBankInfo();
        System.out.println("Over Draft Limit : " + overDraftLimit);
    }


}
