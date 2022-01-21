package by.epam.designPattern.chainOfResponsibility;

public class Employee {
    private int id;
    private String login;
    private String password;

    public Employee(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }
}