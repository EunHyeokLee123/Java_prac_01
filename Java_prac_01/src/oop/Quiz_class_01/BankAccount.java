package oop.Quiz_class_01;

public class BankAccount {
    private long balance;
    private String accountNumber;
    private String accountHolder;

    BankAccount(String accountNumber, String accountHolder, long balance){
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public long getBalance(){
        return this.balance;
    }
    public void deposit(long num){
        if(num<0){
            System.out.println("입금액이 올바르지 않습니다.");
            return;
        }
        this.balance += num;
    }
    public void withdraw(long num){
        if(this.balance>=num && num>0)
            this.balance -= num;
        else {
            System.out.println("잔액이 부족하거나 잘못된 출금액입니다.");
            return;
        }
    }

}
