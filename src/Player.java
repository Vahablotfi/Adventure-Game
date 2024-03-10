import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Player {

    private Room currentRoom;
    private ArrayList<Item> inventoryArr;

    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
        this.inventoryArr = new ArrayList<>();
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

    public void setInventoryArr(ArrayList<Item> inventoryArr) {
        this.inventoryArr = inventoryArr;
    }

    public void takeItem(String itemName) {
        Item item = currentRoom.findItem(itemName);
        if (item != null) {
            currentRoom.removeItem(item);
            addItem(item);
            System.out.println("You took the " + item.getShortName() + ".");
        } else {
            System.out.println("There is nothing like " + itemName + " to take around here.");
        }
    }

    public void dropItem(String itemName) {
        Item item = findItemInInventory(itemName);
        if (item != null) {
            removeItem(item);
            currentRoom.addItem(item);
            System.out.println("You dropped the " + item.getShortName() + ".");
        } else {
            System.out.println("You don't have anything like " + itemName + " in your inventory.");
        }
    }

    public Item findItemInInventory(String itemName) {
        for (Item item : inventoryArr) {
            if (item.getShortName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public String look() {
        StringBuilder roomInfo = new StringBuilder();
        roomInfo.append("You are in: ").append(currentRoom.getName());
        roomInfo.append("\n").append(currentRoom.getDescription());
        return roomInfo.toString();
    }

    public String showInventory() {
        List<Item> roomItems = currentRoom.getItemsInRoomArr();

        if (roomItems.isEmpty()) {
            return "The room is empty.";
        } else {
            StringJoiner joiner = new StringJoiner(", ");
            for (Item item : roomItems) {
                joiner.add(item.getShortName());
            }
            return "Inventory: " + joiner.toString();
        }
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
