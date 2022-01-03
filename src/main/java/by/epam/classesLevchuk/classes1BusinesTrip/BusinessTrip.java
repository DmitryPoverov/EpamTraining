package by.epam.classesLevchuk.classes1BusinesTrip;

public class BusinessTrip {

    private static final int DAILY_RATE = 700;
    private String account;
    private int transportExpenses;
    private int days;

    public BusinessTrip() {
    }

    public BusinessTrip(String account, int transport, int days) {
        this.account = account;
        this.transportExpenses = transport;
        this.days = days;
    }

    public String getAccount() {
        return account;
    }
    public int getTransportExpenses() {
        return transportExpenses;
    }
    public int getDays() {
        return days;
    }

    public int getTotal() {
        return (DAILY_RATE * days)+ transportExpenses;
    }
    public String getPriceInByn(int sum) {
        return (sum/100) + "." + (sum%100 < 10 ? "0" + sum%10 : sum%100);
        // teacher's version: return sum/100 + "." + cent/10%10 + cent%10
        // the decision from the group: return String.format("%d.%02d", sum/100, sum%100);
    }

    public void setAccount(String account) {
        this.account = account;
    }
    public void setTransportExpenses(int transportExpenses) {
        this.transportExpenses = transportExpenses;
    }
    public void setDays(int days) {
        this.days = days;
    }

    public void show() {
        System.out.println("daily rate = " + getPriceInByn(DAILY_RATE));
        System.out.println("employee's name = " + account);
        System.out.println("transport expenses= " + getPriceInByn(transportExpenses));
        System.out.println("days = " + days);
    }

    @Override
    public String toString() {
        return account  + ";" + days + ";" + getPriceInByn(transportExpenses) + ";" + getPriceInByn(getTotal());
    }
}
