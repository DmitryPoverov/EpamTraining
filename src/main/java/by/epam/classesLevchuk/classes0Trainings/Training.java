package by.epam.classesLevchuk.classes0Trainings;

import java.util.Random;
import java.util.Scanner;

/*временно закомментировал, чтобы проверить примеры из материала преподавателя
public class Training {
    public static void main(String[] args) {
        int a = 3, b = 5;
        b +=a +=b +=7;
        System.out.println(a);
        System.out.println(b);
        float change1 = 2.1f - 1f;
        System.out.println(change1);
        double change2 = 2 - 1.1;
        System.out.println(change2);
    }
}*/

public class Training {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input n1");
        int n = sc.nextInt();
        int[] values = new int[n];
        System.out.println("Input array elements");
        for(int i=0; i < values.length; i++) {
            values[i] = sc.nextInt();
        }
        System.out.println("output, version 1");
        for(int value : values) {
            System.out.println(value);
        }
        System.out.println("output, version 2");
        int i = 0;
        for(int value : values) {
            System.out.printf("values[%d] = %d\n", i++, value);
        }
        System.out.println("Max - min = " + getRange(values));

        double[] randoms = getRandoms(5);
        for (double random : randoms) {
            System.out.println(random);
        }
        System.out.println(Math.abs(-3.001));
        System.out.println("------------------------------------");

        // Пример от Левчука с измененным n на n1, т.к. у меня здесь уже была переменная n.
        // Этот пример считает отрицательную или положительную степень числа 2.0
        int n1 = 3;
        double x = 2.0;
        double xPowerN = 1.0;
        for(int k = 0; k < Math.abs(n1); k++) {
            xPowerN *= x;
        }
        System.out.println(x + " in " + n1 + "-th power equals "
                + (n1 >= 0 ? + xPowerN : 1.0 / xPowerN));
        System.out.printf("%.3f in %d-th power equals %.3f", x, n1,
                (n1 >= 0 ? xPowerN : 1.0 / xPowerN));
        System.out.println("\n------------------------------------");
    }

    static int getRange(int[] values) { // изменил возвращаемый тип на int
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int value : values){
            if(value < min) {
                min = value;
            }
            if(value > max) {
                max = value;
            }
        }
        System.out.println("min: " + min);  // игрался с примерами преподавателя: добавил вывод min и max элементов.
        System.out.println("max: " + max);
        return max - min;
    }

    static double[] getRandoms(int n) {
        double[] randoms = new double[n];
        for(int i = 0; i < n; i++){
            Random random = new Random();                            // добавил Random, т.к. Math.random, преподавателя
            randoms[i] = random.nextInt(10) + Math.random();   // давал только значения меньше 1.
        }
        return randoms;
    }
}