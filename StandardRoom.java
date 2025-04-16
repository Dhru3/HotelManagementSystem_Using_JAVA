package Mini;

// StandardRoom.java
public class StandardRoom extends Room {
    private boolean isSmokingAllowed;

    public StandardRoom() {
        // Default initialization
    }

    public StandardRoom(String roomNumber, int capacity, boolean hasBalcony, boolean isSmokingAllowed) {
        super(roomNumber, capacity, hasBalcony);
        this.isSmokingAllowed = isSmokingAllowed;
    }

    @Override
    public float getPricePerNight() {
        return 5000.0f;
    }
}
