package interviewprep.morganstanley.racecondition;

/**
 * @author jianshen
 */
/*
 * on site race condition question: how many ways to fix the race condition other than AtomicInteger, and I think at
 * least can apply synchronized on Account deposit and withdraw method should work. Note that synchronized on TransferTask
 * transfer method won't work since it won't protect the case of multiple threads.
 */
public class TransferTest {
    public static void main(String[] args){
        Account debitAccount = new Account(100, 1);
        Account creditAccount = new Account(100, 2);
        int count = 10000;

        TransferTask transferTask1 = new TransferTask(debitAccount, creditAccount, 5, count);
        TransferTask transferTask2 = new TransferTask(creditAccount, debitAccount, 5, count);

        Thread thread1 = new Thread(transferTask1);
        Thread thread2 = new Thread(transferTask2);

        System.out.println("Before transfer debit account balance is: " + debitAccount.getBalance() + ", credit account balance is: " + creditAccount.getBalance());
        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("After transfer debit account balance is: " + debitAccount.getBalance() + ", credit account balance is: " + creditAccount.getBalance());

    }
}
