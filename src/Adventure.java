import java.util.ArrayList;

public class Adventure {
    private Map gameMap;
    private Player gamePlayer;
    private Room currentRoom;

    public Adventure() {
        gameMap = new Map();
        gamePlayer = new Player();
        currentRoom = gameMap.getRoom1();

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
    public ArrayList<Item> inventory(){
        return gamePlayer.getInventoryArr();
    }


    public boolean moveAround(String direction) {

        switch (direction) {
            case "go north", "n", "north" -> {
                if (currentRoom.getNorth() != null) {
                    setCurrentRoom(currentRoom.getNorth());
                    currentRoom.setVisited();
                    return true;
                } else {
                    return false;
                }
            }
            case "go south", "s", "south" -> {
                if (currentRoom.getSouth() != null) {
                    setCurrentRoom(currentRoom.getSouth());
                    currentRoom.setVisited();
                    return true;
                } else {
                    return false;
                }
            }
            case "go east", "e", "east" -> {
                if (currentRoom.getEast() != null) {
                    setCurrentRoom(currentRoom.getEast());
                    currentRoom.setVisited();
                    return true;
                } else {
                    return false;
                }
            }
            case "go west", "w", "west" -> {
                if (currentRoom.getWest() != null) {
                    setCurrentRoom(currentRoom.getWest());
                    currentRoom.setVisited();
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
        Item item = currentRoom.findItem(itemName);
        if (item != null) {
            currentRoom.removeItem(item);
            gamePlayer.addItem(item);
            return item;
        } else {

            return null;

        }
    }
    public Item dropItem(String itemName) {
        Item item = findItemInInventory(itemName);
        if (item != null) {
            gamePlayer.removeItem(item);
            currentRoom.addItem(item);
            return item;
        } else {
            return null;
        }
    }

    public Item findItemInInventory(String itemName) {
        for (Item item : gamePlayer.getInventoryArr()) {
            if (item.getShortName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }


}


