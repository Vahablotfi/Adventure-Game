import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private boolean visited;
    private Room north;
    private Room east;
    private Room west;
    private Room south;
    private ArrayList<Item> itemsInRoomArr = new ArrayList<>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.visited = false;
    }

    public void addItem(Item item) {
        itemsInRoomArr.add(item);
    }

    public void removeItem(Item item) {
        itemsInRoomArr.remove(item);
    }

    public ArrayList<Item> getItemsInRoomArr() {
        return itemsInRoomArr;
    }

    public void setItemsInRoomArr(ArrayList itemsInRoomArr) {
        this.itemsInRoomArr = itemsInRoomArr;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String getVisited() {
        if (!visited) {
            visited = true;
            return description;
        } else {
            return "I've already been in this room";
        }
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void String(boolean visited) {
        this.visited = false;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }


}
