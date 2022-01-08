package by.epam.multithreading.dmDev25.lesson11DeadLock;

public class AccountRunner {
    public static void main(String[] args) throws InterruptedException {

        Account account1 = new Account(20000);
        Account account2 = new Account(20000);

        AccountThread accountThread1 = new AccountThread(account1, account2);
        AccountThread accountThread2 = new AccountThread(account1, account2);
        AccountThread accountThread3 = new AccountThread(account1, account2);

        accountThread1.start();
        accountThread2.start();
        accountThread3.start();

        accountThread1.join();
        accountThread2.join();
        accountThread3.join();

        System.out.println(account1);
        System.out.println(account2);
    }
}
