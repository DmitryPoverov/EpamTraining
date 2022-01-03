package by.epam.multithreading.dmDevPractice1;

import java.util.Random;

public final class RandomUtil { // cause the class is util we add access modifier "final" to deny inheriting this class

    private static final Random RANDOM = new Random();  // it's threadsafe and we can call it with no fear
    private static final int DEFAULT_BOUND = 10;

    private RandomUtil(){
    }

    public static int getRandom() {
        return RANDOM.nextInt(DEFAULT_BOUND);
    }
    public static int getRandom(int bound) {
        return RANDOM.nextInt(bound);
    }
}