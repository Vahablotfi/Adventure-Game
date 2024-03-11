import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Player {

    private Room currentRoom;
    private ArrayList<Item> inventoryArr;

    public Player(Room currentRoom) {//    // Konstruktør der opretter en ny spiller og initialiserer den nuværende position og beholdning
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
    // Metode der lader spilleren tage et item fra det nuværende rum og tilføje det til inventory
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
    // Metode der lader spilleren smide et item fra inventory i det nuværende rum
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

    // Metode der finder et item i spillerens inventory baseret på dets navn
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
    // Metode der returnerer en tekstbeskrivelse af det nuværende rum
    public String look() {
        StringBuilder roomInfo = new StringBuilder();
        roomInfo.append("You are in: ").append(currentRoom.getName());
        roomInfo.append("\n").append(currentRoom.getDescription());
        return roomInfo.toString();
    }
    // Metode der returnerer en liste af items i det nuværende rum
    public String showRoomInventory() {
        List<Item> roomItems = currentRoom.getItemsInRoomArr();
        if (roomItems.isEmpty()) {
            return "The room is empty.";
        } else {
            StringJoiner joiner = new StringJoiner(", ");//opbygge en streng, der repræsenterer listen af items enten i spillerens inventory eller i det nuværende rum
            for (Item item : roomItems) {
                joiner.add(item.getShortName());
            }
            return joiner.toString();
        }
    }
    // Metode der returnerer en liste af items i spillerens inventory
    public String showInventory() {
        if (inventoryArr.isEmpty()) {
            return "Your inventory is empty";
        } else {
            StringJoiner joiner = new StringJoiner(", ");
            for (Item item : inventoryArr) {
                joiner.add(item.getShortName());
            }
            return " " + joiner.toString();
        }
    }

    // Metode der lader spilleren bevæge sig i forskellige retninger baseret på input
    public boolean moveAround(String direction) {

        switch (direction) {
            case "go north", "n", "north" -> {
                if (currentRoom.getNorth() != null) {
                    setCurrentRoom(currentRoom.getNorth());
                    return true;
                } else {
                    return false;
                }
            }
            case "go south", "s", "south" -> {
                if (currentRoom.getSouth() != null) {
                    setCurrentRoom(currentRoom.getSouth());
                    return true;
                } else {
                    return false;
                }
            }
            case "go east", "e", "east" -> {
                if (currentRoom.getEast() != null) {
                    setCurrentRoom(currentRoom.getEast());
                    return true;
                } else {
                    return false;
                }
            }
            case "go west", "w", "west" -> {
                if (currentRoom.getWest() != null) {
                    setCurrentRoom(currentRoom.getWest());
                    return true;
                } else {
                    return false;
                }
            }
            default -> {
                return false;
            }
        }

    }
}
