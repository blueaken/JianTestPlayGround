package realworld.interviewprep.morganstanley;

/**
 * Created by jianshen on 1/11/15.
 */
/*
 * In the Bank Account example below, if 2 transfer operations between 2 accounts occur at the same time:
 * transfer(a, b, 100.0) and transfer(b, a, 50.0). Deadlock will happen they are trying to acquire the
 * resources in the reverse order.
 */
public class BankAccount_DeadLockDemo {
    private double balance;
    private int accountId;

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        balance -= amount;
    }

    public void transfer (BankAccount_DeadLockDemo from, BankAccount_DeadLockDemo to, double amount){
        synchronized (from){
            synchronized (to){
                from.withdraw(amount);
                to.deposit(amount);
            }
        }
    }
}
