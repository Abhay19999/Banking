import entity.SavingsAccount;
import service.TransactionManagment;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("1223","Abhay");

        SavingsAccount savingsAccount = new SavingsAccount(12001,1000,0.2);

        user1.addAccount(savingsAccount);
//      savingsAccount.addInterest();
        TransactionManagment transactionManagment = new TransactionManagment();

        transactionManagment.deposit(savingsAccount,2000);
        transactionManagment.printBalance(savingsAccount);

    }
}