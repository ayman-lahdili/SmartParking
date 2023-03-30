/* Afin de différentier un node (position) et un parking, on a crée cette classe, qui extend Node. */


public class Parking extends Node {
    
    public int capacity; // La capacité maximale du parking.
    public int occupancy;   // Le nombre de voiture dans le parking à un moment donné.
    public int flux;    // Le flux de voiture qui rentrent dans le parking.

    /**
     * 
     * @param id 
     * @param capacity
     * @param occupancy
     * @param flux
     */
    public Parking(String id, int capacity, int occupancy, int flux) throws IllegalArgumentException {
        super(id);
        this.capacity = capacity;
        this.occupancy = occupancy;
        this.flux = flux;

        if (occupancy<0) {
            throw new IllegalArgumentException("Occupancy cannot be negative"); // Si le nombre de voitures dans le parking est négatif, il y a un erreur.
        }
        
        if (capacity<0) {
            throw new IllegalArgumentException("Occupancy cannot be negative"); // Si la capacité maximale de voitures est négative, il y a un erreur.
        }
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Parking " + id + ": capacity=" + capacity + ", occupancy=" + occupancy + ", flux=" + flux;
    }

}
