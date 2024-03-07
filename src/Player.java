import java.util.ArrayList;

public class Player {

    private Room currentRoom;
    private ArrayList<Item> inventoryArr;

    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
        this.inventoryArr = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        inventoryArr.add(item);
    }

    public void removeItem(Item item) {
        inventoryArr.remove(item);
    }

    public ArrayList<Item> getInventoryArr() {
        return inventoryArr;
    }

    public void setInventoryArr(Item item) {
        this.inventoryArr = inventoryArr;
    }

    public void takeItem(Item item) {
        inventoryArr.add(item);
        getCurrentRoom().removeItem(item);
    }

    public void dropItem(Item item) {
        inventoryArr.add(item);
        getCurrentRoom().removeItem(item);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public String look() {
        String roomInfo = "Your are in: " + currentRoom.getName() + "\n" + currentRoom.getDescription() + "\n";
        return roomInfo;
    }

    public boolean moveAround(String direction) {

        switch (direction) {
            case "go north":
            case "n":
            case "north":
                if (currentRoom.getNorth() != null) {
                    setCurrentRoom(currentRoom.getNorth());
                    return true;
                } else {
                    return false;
                }
            case "go south":
            case "s":
            case "south":
                if (currentRoom.getSouth() != null) {
                    setCurrentRoom(currentRoom.getSouth());
                    return true;
                } else {
                    return false;
                }
            case "go east":
            case "e":
            case "east":
                if (currentRoom.getEast() != null) {
                    setCurrentRoom(currentRoom.getEast());
                    return true;
                } else {
                    return false;
                }
            case "go west":
            case "w":
            case "west":
                if (currentRoom.getWest() != null) {
                    setCurrentRoom(currentRoom.getWest());
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }

    }
}
