import java.util.ArrayList;


public class Player {
    private ArrayList<Item> inventoryArr;
    private int health;

    public Player() {
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
    public int getHealth() {
        return health;
    }
    public void setHealth(int health){
        this.health = health;
    }
//    public void getHealthPoints (int points){
//        setHealth(getHealth()+ points);
//
//    }


}


