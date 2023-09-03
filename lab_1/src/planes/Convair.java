package planes;

public class Convair extends Plane {
    public Convair(String name, int seats, float load_cap) {
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
