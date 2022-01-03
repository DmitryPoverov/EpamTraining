package by.epam.classesLevchuk.classes2Material;

public class Material {

    private final String name;
    private final double DENSITY;

    // a ridiculous constructor that answers task condition.
    public Material() {
        name = null;
        DENSITY = 0;
    }

    public Material(String name, double density) {
        this.name = name;
        DENSITY = density;
    }

    public String getName() {
        return name;
    }
    public double getDensity() {
        return DENSITY;
    }

    @Override
    public String toString() {
        return name + ';' + DENSITY;
    }
}
