package interviewprep.morganstanley.racecondition;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jianshen
 */
public class Account {
    private AtomicInteger balance = new AtomicInteger();
    private int accountId;

    public Account(int balance, int accountId) {
        this.balance.set(balance);
        this.accountId = accountId;
    }

    public AtomicInteger getBalance() {
        return balance;
    }

    public void deposit(int amount){
        balance.getAndAdd(amount);
    }

    public void withdraw(int amount){
        balance.getAndAdd(-amount);
    }
}
