package interviewprep.morganstanley.racecondition;

/**
 * @author jianshen
 */
public class TransferTask implements Runnable {
    Account debitAccount;
    Account creditAccount;
    int amount;
    int count;

    public TransferTask(Account debitAccount, Account creditAccount, int amount, int count) {
        this.debitAccount = debitAccount;
        this.creditAccount = creditAccount;
        this.amount = amount;
        this.count = count;
    }

    public void run(){
        for (int i=0; i<count; i++){
            transfer(debitAccount, creditAccount, amount);
        }
    }

    private void transfer(Account debitAccount, Account creditAccount, int amount){
        debitAccount.withdraw(amount);
        creditAccount.deposit(amount);
    }
}
