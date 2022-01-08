package by.epam.multithreading.dmDev25.lesson11DeadLock;

public class Account {

    private static int generator = 1;
    private int id;
    private int money;

    public Account(int money) {
        this.id = generator++;
        this.money = money;
    }

    public void add(int money) {
        this.money += money;
    }

    public boolean takeOff(int money) {
        if (money <= this.money) {
            this.money -= money;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }
}
