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
    private ArrayList<Enemy> enemiesInRoomArr = new ArrayList<>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.visited = false;
    }
    public void addEnemy(Enemy enemy){
        enemiesInRoomArr.add(enemy);
    }

    public void removeEnemy(Enemy enemy){
        enemiesInRoomArr.remove(enemy);
    }

    public void addItem(Item item) {
        itemsInRoomArr.add(item);
    }

    public void removeItem(Item item) {
        itemsInRoomArr.remove(item);
    }

    public void addFood(Food food) {
        itemsInRoomArr.add(food);
    }

    public void removeFood(Food food) {
        itemsInRoomArr.remove(food);
    }
    public ArrayList<Enemy> getEnemiesInRoomArr(){
        return enemiesInRoomArr;
    }

    public ArrayList<Item> getItemsInRoomArr() {
        return itemsInRoomArr;
    }

    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }


    public boolean getVisited() {
        return visited;
    }

    public void setVisited() {
        if (!visited) {
            visited = true;
        }
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
