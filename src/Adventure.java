import java.lang.reflect.Type;
import java.security.PublicKey;
import java.util.ArrayList;

public class Adventure {
    private Map gameMap;
    private Player gamePlayer;
    private Room currentRoom;



    public Adventure() {
        gameMap = new Map();
        gamePlayer = new Player();
        currentRoom = gameMap.getRoom1();
        currentRoom.setVisited();
        gamePlayer.setHealth(100);
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

//    public Weapon enemyDropWeapon() {
//        Weapon weapon =
//        //Weapon enemyWeapon = getEnemy().getWeapon();
//        enemy.removeEnemyWeapon();
//    }


    public Item findItemInArray(String itemName, ArrayList<Item> itemsList) {
        for (Item item : itemsList) {
            if (item.getShortName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }



    public Food playerEat(String foodName) {
        Item foodInInventory =  findItemInArray(foodName, gamePlayer.getInventoryArr());
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
    public int shot() {
        Weapon equippedWeapon = getGamePlayer().getEquippedWeapon();
        int remainingUse = 0;
        if (equippedWeapon == null){
            remainingUse = -1;
        } else if (equippedWeapon.getRemainingUse() > 0)  {
            equippedWeapon.useWeapon();
            remainingUse = equippedWeapon.getRemainingUse();
        }
        return remainingUse;
    }

    public int battle(Enemy wantedEnemy) {

        // find enemies in room, and save ina variable
        Enemy foundedEnemy= findEnemiesInArray(wantedEnemy.getName(), getCurrentRoom().getEnemiesInRoomArr());

        if( shot() == -1){
            // no equipped weapon -1
            return -1;
        }
        if (shot() == 0){
            // No ammunition 0
            return 0;
        }
        if (foundedEnemy == null){
            // no enemy founded -2
            return -2;
        }
        //shot enemy
        int damageOnEnemy = getGamePlayer().getEquippedWeapon().getDamagePoints();
        foundedEnemy.hit(damageOnEnemy);
        // enemy attack
        int damageOnPlayer = foundedEnemy.attack();

        gamePlayer.hit(damageOnPlayer);

        if( gamePlayer.die()){
            // died player -3
            return -3;
        }
        if (foundedEnemy.die())
        // enemy died -4
        {
            Weapon enemyWeapon = foundedEnemy.getWeapon();
            currentRoom.addItem(enemyWeapon);
            foundedEnemy.setWeapon(null);
            currentRoom.removeEnemy(foundedEnemy);
            return -4;
        }

        return -5;
    }


//    public Enemy killEnemy(Enemy enemyToKill){
//
//    }



    public Enemy findEnemiesInArray(String enemyName, ArrayList<Enemy> enemiesInRoom){
        Enemy requestedEnemy = null;
        for (Enemy enemy : enemiesInRoom){
            if (enemy.getName().equalsIgnoreCase(enemyName)){
                requestedEnemy = enemy;
            }
        }
        return requestedEnemy;
    }






}


