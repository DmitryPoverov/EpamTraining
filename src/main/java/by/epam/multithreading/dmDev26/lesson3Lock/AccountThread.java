package by.epam.multithreading.dmDev26.lesson3Lock;

public class AccountThread extends Thread {

    private final Account accountFrom;
    private final Account accountTo;

    public AccountThread(Account accountFrom, Account accountTo) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            lockAccounts(); // this method has endless cycle and until it will catch monitor we don't go to the 17 line
            try {
                if (accountFrom.takeOff(10)) {
                    accountTo.add(10);
                }
            } finally {
                accountFrom.getLock().unlock();
                accountTo.getLock().unlock();
            }

        }
    }

    private void lockAccounts() {
        while (true) {
            boolean fromLockResult = accountFrom.getLock().tryLock();
            boolean toLockResult = accountTo.getLock().tryLock();
            if (fromLockResult && toLockResult) {
                break;
            }
            if (fromLockResult) {   // we have to unlock only previously locked object
                accountFrom.getLock().unlock();
            }
            if (toLockResult) {     // if we'll try unlock is not locked object - we'll get an exception
                accountTo.getLock().unlock();
            }
        }
    }
}
