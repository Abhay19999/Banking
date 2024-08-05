import entity.ChequingAccount;
import entity.SavingsAccount;
import service.TransactionManagment;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("1223","Abhay");

//        SavingsAccount savingsAccount = new SavingsAccount(12001,1000,0.2);
//
//        user1.addAccount(savingsAccount);
////      savingsAccount.addInterest();
//        TransactionManagment transactionManagment = new TransactionManagment();
//
//        transactionManagment.deposit(savingsAccount,2000);
//        transactionManagment.withdraw(savingsAccount, 300);
//        transactionManagment.printBalance(savingsAccount);

        ChequingAccount chequingAccount = new ChequingAccount(123456789L, "Karan Rana",
                4389271441L, "1234 Devon Road", "London", "Ontario",
                50000.0d);

        ChequingAccount chequingAccount1 = new ChequingAccount(987654321L, "Peter",
                2342342342L, "999 First Street", "St Thomas", "Ontario",
                40000);

chequingAccount.displayBankInfo();
chequingAccount1.displayBankInfo();

    }
}