package Mini;

// SuiteRoom.java
public class SuiteRoom extends Room {
    private int numberOfBedrooms;

    public SuiteRoom() {
        // Default initialization
    }

    public SuiteRoom(String roomNumber, int capacity, boolean hasBalcony, int numberOfBedrooms) {
        super(roomNumber, capacity, hasBalcony);
        this.numberOfBedrooms = numberOfBedrooms;
    }

    @Override
    public float getPricePerNight() {
        return 10000.0f;
    }
}
