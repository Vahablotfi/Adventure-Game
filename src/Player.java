import java.util.ArrayList;


public class Player {

    private ArrayList<Item> inventoryArr;

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


}


