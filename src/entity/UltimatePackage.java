package entity;

public class UltimatePackage extends ChequingAccount{


    public UltimatePackage(long accountNumber, String accountHolderName,
                           long primaryPhoneNumber, String addressLine1, String city,
                           String state, double accountBalance, double overDraftLimit) {
        super(accountNumber, accountHolderName, primaryPhoneNumber,
                addressLine1, city, state, accountBalance, overDraftLimit);
    }

    @Override
    public void displayBankInfo() {
        super.displayBankInfo();
        System.out.println("This is the Ultimate Package Class,,,,,");
    }
}
