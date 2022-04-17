package lintcode.multithread.bankaccount_2497;

/*
Idea: 和2496相似本题因为存在多线程对同一变量进行操作，需要使用锁来解决线程间竞争(ref 1),但锁并不能解决
      线程之间协调工作问题，这里使用wait和notifyAll方法来协调(ref 2). 本题也存在多个线程查看共享变量account的
      需求，因此使用volitle关键字(ref 3)

Ref - https://www.lintcode.com/problem/2497/solution/36556
    - https://www.liaoxuefeng.com/wiki/1252599548343744/1306580911915042
    - https://www.cnblogs.com/paddix/p/5428507.html
*/
public class Bank_2497 {
    private volatile int account;
    // write your code

    public Bank_2497(int account) {
        this.account = account;
        // write your code

    }

    public synchronized void saveMoney(int amount) throws Exception {
        // write your code
        try {
            account = Main.saveOperation(account, amount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.notifyAll();
    }

    public synchronized void withdrawMoney(int amount) throws Exception {
        // write your code
        while (this.account < amount) {
            this.wait();
        }
        try {
            account = Main.withdrawOperation(account, amount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int checkAccount(){
        // write your code
        return this.account;
    }
}
