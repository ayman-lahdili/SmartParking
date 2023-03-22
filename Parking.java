
public class Parking extends Node {
    
    public int capacity;
    public int occupancy;
    public int flux;

    /**
     * 
     * @param id 
     * @param capacity
     * @param occupancy
     * @param flux
     */
    public Parking(String id, int capacity, int occupancy, int flux) {
        super(id);
        this.capacity = capacity;
        this.occupancy = occupancy;
        this.flux = flux;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Parking " + id + ": capacity=" + capacity + ", occupancy=" + occupancy + ", flux=" + flux;
    }

}
