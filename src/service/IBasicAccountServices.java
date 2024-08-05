package service;

public interface IBasicAccountServices {
    public abstract double eTransfer(double eTransferAmount);


    //To check account balance
    public abstract double checkAccountBalance();
}
