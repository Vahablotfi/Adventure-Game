import java.util.ArrayList;

public class Adventure {
    private Map gameMap;
    private Player gamePlayer;
    private Room currentRoom;
    private Enemy enemy;


    public Adventure() {
        gameMap = new Map();
        gamePlayer = new Player();
        currentRoom = gameMap.getRoom1();
        currentRoom.setVisited();
        gamePlayer.setHealth(100);
    }
    public Enemy getEnemy(){
        return enemy;
    }


    public Map getGameMap() {
        return gameMap;
    }

    public Player getGamePlayer() {
        return gamePlayer;
    }

    public void setGameMap(Map gameMap) {
        this.gameMap = gameMap;
    }

    public void setGamePlayer(Player gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    // to show player Items
    public ArrayList<Item> inventory() {
        return gamePlayer.getInventoryArr();
    }



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


    public Item takeItem(String itemName) {
        Item item = findItemInArray(itemName, currentRoom.getItemsInRoomArr());
        if (item != null) {
            currentRoom.removeItem(item);
            gamePlayer.addItem(item);
            return item;
        } else {

            return null;

        }
    }

    public void markVisitedRoom() {
        currentRoom.setVisited();
    }

    public Item dropItem(String itemName) {
        Item item = findItemInArray(itemName, gamePlayer.getInventoryArr());
        if (item != null) {
            if (item instanceof Weapon) {
                gamePlayer.setEquippedWeapon(null);
            }
            gamePlayer.removeItem(item);
            currentRoom.addItem(item);
        }
        return item;
    }


    public Item findItemInArray(String itemName, ArrayList<Item> itemsList) {
        for (Item item : itemsList) {
            if (item.getShortName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public Food playerEat(String foodName) {
        Item foodInInventory = findItemInArray(foodName, gamePlayer.getInventoryArr());
        Item foodInRoom = findItemInArray(foodName, currentRoom.getItemsInRoomArr());
        Food foodToHandel = null;

        if (foodInRoom instanceof Food) {
            foodToHandel = (Food) foodInRoom;
            gamePlayer.eatFood(foodToHandel);
            currentRoom.removeFood((Food) foodInRoom);

        } else if (foodInInventory instanceof Food) {
            foodToHandel = (Food) foodInInventory;
            gamePlayer.eatFood(foodToHandel);
            gamePlayer.removeItem(foodInInventory);

        }

        return foodToHandel;
    }

    public Item equipWeapon(String weaponName) {
        Item weaponToTake = findItemInArray(weaponName, inventory());
        if (weaponToTake instanceof Weapon) {
            gamePlayer.setEquippedWeapon((Weapon) weaponToTake);
        }

        return weaponToTake;

    }

}


