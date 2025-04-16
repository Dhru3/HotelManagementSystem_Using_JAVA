package Mini;

// DeluxeRoom.java
public class DeluxeRoom extends Room {
    private boolean hasHotTub;

    public DeluxeRoom() {
        // Default initialization
    }

    public DeluxeRoom(String roomNumber, int capacity, boolean hasBalcony, boolean hasHotTub) {
        super(roomNumber, capacity, hasBalcony);
        this.hasHotTub = hasHotTub;
    }

    @Override
    public float getPricePerNight() {
        return 8500.0f;
    }
}
