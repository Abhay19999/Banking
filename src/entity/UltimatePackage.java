package entity;

public class UltimatePackage extends ChequingAccount{

    public UltimatePackage(long accountNumber, String accountHolderName,
                           long primaryPhoneNumber, String addressLine1,
                           String city, String state, double accountBalance) {
        super(accountNumber, accountHolderName, primaryPhoneNumber, addressLine1, city, state, accountBalance);
    }
}
