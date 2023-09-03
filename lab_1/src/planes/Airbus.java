package planes;

public class Airbus extends Plane {
    public Airbus(String name, int seats, float load_cap) {
        this.name = name;
        this.seats = seats;
        this.load_capacity = load_cap;
    }

    @Override
    public String toString() {
        return
                "name = '" + name + '\'' +
                        ", seats = " + seats +
                        ", load_capacity = " + load_capacity + " kg";
    }
}

