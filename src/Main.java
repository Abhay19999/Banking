import entity.ChequingAccount;
import entity.SavingsAccount;
import entity.StudentBankingAdvantagePlan;


public class Main {
    public static void main(String[] args) {

        SavingsAccount savingsAccount = new SavingsAccount(123456L,"Abhay",
                123456789,"Scarborough","Toronto","ON",2000.0d);

        savingsAccount.deposit(122);
        savingsAccount.displayBankInfo();

        ChequingAccount chequingAccount = new ChequingAccount(123456789L, "Karan",
                4389271441L, "1234 Devon Road", "London", "Ontario",
                50000.0d);

        ChequingAccount chequingAccount1 = new StudentBankingAdvantagePlan(987654321L, "Peter",
                2342342342L, "999 First Street", "St Thomas", "Ontario",
                40000, true);

        chequingAccount.displayBankInfo();
        chequingAccount1.displayBankInfo();

    }
}