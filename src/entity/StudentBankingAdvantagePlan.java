package entity;

public class StudentBankingAdvantagePlan extends ChequingAccount{

public String features;
public boolean isEnrolledFullTime = true;

    public StudentBankingAdvantagePlan(long accountNumber, String accountHolderName, long primaryPhoneNumber,
                                       String addressLine1, String city, String state,
                                       double accountBalance, double overDraftLimit,
                                       boolean isEnrolledFullTime) {
        super(accountNumber, accountHolderName, primaryPhoneNumber, addressLine1, city, state, accountBalance, overDraftLimit);
        this.isEnrolledFullTime = isEnrolledFullTime;
    }

    @Override
    public void displayBankInfo() {

        if(isEnrolledFullTime) {
            System.out.println("==================== Student Banking Advantage Plan ===============");
            super.displayBankInfo();
            System.out.println("Features of Student banking Advantage Plan: Eligible Customer will get the iPad ");
        } else {
            System.out.println("You are not eligible for Student Banking Advantgae Account");}
    }


}
