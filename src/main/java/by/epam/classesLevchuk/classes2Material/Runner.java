package by.epam.classesLevchuk.classes2Material;

public class Runner {

    public static void main(String[] args) {

        Material iron = new Material("iron", 7850.0);
        Material copper = new Material("copper", 8500);

        Subject wire = new Subject("wire", iron, 0.03);
        System.out.println(wire);

        wire.setMaterial(copper);
        System.out.printf("The wire mass is %s", wire.getMass());
    }
}
