import entity.ChequingAccount;
import entity.SavingsAccount;


public class Main {
    public static void main(String[] args) {
        User user1 = new User("1223","Abhay");

        SavingsAccount savingsAccount = new SavingsAccount(123456L,"Abhay",123456789,"Scarborough","Toronto","ON",2000.0d);

////      savingsAccount.addInterest();

        savingsAccount.deposit(2000);
        savingsAccount.displayBankInfo();
//        transactionManagment.withdraw(savingsAccount, 300);
//        transactionManagment.printBalance(savingsAccount);

//        ChequingAccount chequingAccount = new ChequingAccount(123456789L, "Karan Rana",
//                4389271441L, "1234 Devon Road", "London", "Ontario",
//                50000.0d);
//
//        ChequingAccount chequingAccount1 = new ChequingAccount(987654321L, "Peter",
//                2342342342L, "999 First Street", "St Thomas", "Ontario",
//                40000);
//
//chequingAccount.displayBankInfo();
//chequingAccount1.displayBankInfo();

    }
}