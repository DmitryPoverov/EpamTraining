package by.epam.multithreading.dmDevTrainings;

public class Runner {

    public static void main(String[] args) {

        ThreadOne one = new ThreadOne();
        Thread two = new Thread(new ThreadTwo());
        ThreadThree three = new ThreadThree();
        one.run();
        two.run();
        three.run();
    }
}
