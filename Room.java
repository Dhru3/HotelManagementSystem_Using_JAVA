package Mini;

public abstract class Room {
    private String roomNumber;
    private int capacity;
    private boolean hasBalcony;

    public Room() {
        // Default initialization
    }

    public Room(String roomNumber, int capacity, boolean hasBalcony) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.hasBalcony = hasBalcony;
    }

    public abstract float getPricePerNight();

    public String getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean hasBalcony() {
        return hasBalcony;
    }
}
