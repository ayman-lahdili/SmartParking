

public class Parking extends Node {
    public int capacity;
    public int occupancy;
    public int flux;

    public Parking(String id, int capacity, int occupancy, int flux) {
        super(id);
        this.capacity = capacity;
        this.occupancy = occupancy;
        this.flux = flux;
    }

    @Override
    public String toString() {
        return "Parking " + id + ": capacity=" + capacity + ", occupancy=" + occupancy + ", flux=" + flux;
    }

}
