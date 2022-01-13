package by.epam.json;

public class Ship implements Runnable {

    private int id;
    private boolean loaded;

    public Ship() {
    }

    public int getId() {
        return id;
    }
    public boolean isLoaded() {
        return loaded;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    @Override
    public void run() {

    }

    @Override
    public String toString() {
        return "Ship[" +
                "id: " + id +
                ", load: " + loaded + ']';
    }
}
