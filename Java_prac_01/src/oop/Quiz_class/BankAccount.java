package oop.Quiz_class;

public class BankAccount {
    private int balance;
    private String accountNumber;
    private String accountHolder;

    BankAccount(String accountNumber, String accountHolder, int balance){
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public int getBalance(){
        return this.balance;
    }
    public void deposit(int num){
        this.balance += num;
    }
    public void withdraw(int num){
        this.balance -= num;
    }

}
