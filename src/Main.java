import entity.ChequingAccount;
import entity.MomentumPlusSavingAccount;
import entity.SavingsAccount;
import entity.StudentBankingAdvantagePlan;


public class Main {
    public static void main(String[] args) {

//        SavingsAccount savingsAccount = new SavingsAccount(123456L,"Abhay",
//                123456789,"Scarborough","Toronto","ON",2000.0d);
//
//        savingsAccount.deposit(122);
//        savingsAccount.displayBankInfo();
//
        ChequingAccount chequingAccount = new ChequingAccount(123456789L,
                "Karan",
                4389271441L, "1234 Devon Road", "London", "Ontario",
                50000.0d, 1500);

        ChequingAccount studentChequingAccount = new StudentBankingAdvantagePlan(987654321L, "Peter",
                2342342342L, "999 First Street", "St Thomas", "Ontario",
                40000, 500, true);

        chequingAccount.withdraw(100);
        chequingAccount.displayBankInfo();
        studentChequingAccount.displayBankInfo();


        //Code is used for MomentumPlusSavingAccount
        MomentumPlusSavingAccount m_account = new MomentumPlusSavingAccount(123456789L, "Rushi",
                434434343L, "Toronto Street", "Toronto", "ON", 41000.0d,
                0.1d,500.0d, 10.0d, 0.03d);
        //below commented code throwing the exceptions
        //m_account.deposit(500.0);
        m_account.withdraw(10);
//        m_account.addInterest();
//        m_account.applyMonthlyFee();
//        m_account.printTransactionHistory();
        m_account.displayBankInfo();



    }
}