package planes;

import java.io.Serializable;

public class Plane implements Serializable {
    protected String name;

    protected int seats;

    protected float load_capacity;

    public String getName() {
        return name;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public float getLoad_capacity() {
        return load_capacity;
    }

    public void setLoad_capacity(float load_capacity) {
        this.load_capacity = load_capacity;
    }

    public void setName(String name) {
        this.name = name;
    }
}
