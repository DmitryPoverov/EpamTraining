package by.epam.classesLevchuk.classes2Material;

public class Subject {

    private String name;
    private Material material;
    private double volume;

    public Subject() {
    }

    public Subject(String name, Material material, double volume) {
        this.name = name;
        this.material = material;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }
    public Material getMaterial() {
        return material;
    }
    public double getVolume() {
        return volume;
    }
    public String getMass () {
        return String.format("%.1f", material.getDensity() * volume);
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setMaterial(Material material) {
        this.material = material;
    }
    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return  name + ";" + material + ";" + volume + ";" + getMass();
    }
}
