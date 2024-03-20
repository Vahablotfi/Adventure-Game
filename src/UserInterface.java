import java.lang.reflect.Array;
import java.util.*;


public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Adventure newAdventure = new Adventure();

    // Array of directions
    final String[] directions = new String[]{"go south", "south", "s",
            "go north", "north", "n",
            "go east", "east", "e",
            "go west","west", "w"};

    // Convert direction Array to a list
    private List<String> directionsList = Arrays.asList(directions);



    public void playingGame() {
        System.out.println("Welcome to the game!");
        look();
        menu();
        String userChoice = " ";

        while (!userChoice.equals("exit")) {
            userChoice = getStringInput().toLowerCase();

            switch (userChoice) {
                //CHOOSE DIRECTION
                case String s when directionsList.contains(s) -> {
                    if (newAdventure.moveAround(userChoice)) {
                        look();
                        if (newAdventure.getCurrentRoom().getVisited()) {
                            System.out.println("This place feels awfully familiar.");
                        } else {
                            newAdventure.markVisitedRoom();
                        }
                    } else {
                        System.out.println("You can't go that way.");
                    }
                }
                //INVENTORY
                case "inventory" -> {
                    System.out.println("Inventory:");
                    showItemInArray(newAdventure.getGamePlayer().getInventoryArr());
                    if (newAdventure.getGamePlayer().getEquippedWeapon()!=null){
                        Weapon equippedWeapon = newAdventure.getGamePlayer().getEquippedWeapon();
                        System.out.println("You are equipped with "+equippedWeapon.getShortName() + ".");
                    }
                }

                //TAKE:
                case String s when s.startsWith("take")-> {
                    if (userChoice.length() >= 5) {
                        String itemToTake = userChoice.substring(4);
                        takeItem(itemToTake.trim());
                    } else {
                        System.out.println("You have to write an item to take.");
                    }

                }
                //DROP
                case String s when s.startsWith("drop") -> {
                    if (userChoice.length() >= 5) {
                        String itemToDrop = userChoice.substring(4);
                        dropItem(itemToDrop.trim());
                    } else {
                        System.out.println("You have to write an item to drop.");
                    }

                }
                //EAT:
                case String s when s.startsWith("eat") -> {
                    if (userChoice.length() >= 4) {
                        String foodToEat = userChoice.substring(3);
                        eat(foodToEat.trim());
                    } else {
                        System.out.println("You have to write a food to eat.");
                    }

                }
                //EQUIP:
                case String s when s.startsWith("equip") -> {
                    if (userChoice.length() >= 6) {
                        String WeaponToEquip = userChoice.substring(5);
                        equip(WeaponToEquip.trim());
                    } else {
                        System.out.println("You have to write a weapon to equip.");
                    }
                }
                case "health" -> health();
                case "look" -> look();
                case "attack" -> attack();
                case "help" -> help();
                case "exit", "exit game" -> System.out.println("Exiting game.");
                default -> System.out.println("That doesn't work.");
            }
        }
    }





    public void menu() {
        System.out.println();
        System.out.println("Choose direction: s/n/w/e");
        System.out.println("Look");
        System.out.println("Inventory");
        System.out.println("Health");
        System.out.println("Take");
        System.out.println("Drop");
        System.out.println("Equip");
        System.out.println("Attack");
        System.out.println("Eat");
        System.out.println("Help");
        System.out.println("Exit game");

    }


    public void look() {
        StringBuilder roomInfo = new StringBuilder();
        roomInfo.append("You are in: ").append(newAdventure.getCurrentRoom().getName());
        roomInfo.append("\n").append(newAdventure.getCurrentRoom().getDescription());
        System.out.println(roomInfo.toString());
        showItemInArray(newAdventure.getCurrentRoom().getItemsInRoomArr());
        showEnemiesInArray(newAdventure.getCurrentRoom().getEnemiesInRoomArr());

    }

    // Method To Print Out Items In An Array List
    public void showItemInArray(ArrayList<Item> playerItems) {
        if (playerItems.isEmpty()) {
            System.out.println("empty");
        } else {
            for (Item item : playerItems) {
                System.out.println(item.getShortName() + ": " + item.getLongName());
            }
        }
    }
    public void showEnemiesInArray(ArrayList<Enemy> enemies){
        if(enemies.isEmpty()){
            System.out.println("No enemies");
        } else{
            for(Enemy enemy : enemies){
                System.out.println(enemy.getName() + ": " + enemy.getDescription());
            }
        }
    }

    public void takeItem(String itemToTake) {
        Item choosenItem =  newAdventure.takeItem(itemToTake);
        if (choosenItem != null) {
            System.out.println("You took the " + choosenItem.getShortName() + ".");
        } else {
            System.out.println("Can not find " + itemToTake + ".");
        }
    }

    public void dropItem(String itemToDrop) {
        Item droppedItem = newAdventure.dropItem(itemToDrop);
        if (droppedItem != null) {
            System.out.println("You dropped " + droppedItem.getShortName() + ".");
        } else{
            System.out.println("You don't have anything like '" + itemToDrop + "' in you inventory.");
        }
    }

    // Method to check Player's remaining Health
    public void health() {
        int playerHealth = newAdventure.getGamePlayer().getHealth();
        System.out.println("Your current health is " + playerHealth + ".");

    }


    public void help() {
        System.out.println("Type 'north', 'south', 'east' or 'west' to choose direction.");
        System.out.println("Type 'look' to look around the room you're currently in.");
        System.out.println("Type 'inventory' to see what's in your inventory.");
        System.out.println("Type 'health' to see your health score.");
        System.out.println("Type 'take' and the item you want to take from the room you're in.");
        System.out.println("Type 'drop' and the item from your inventory you want to drop.");
        System.out.println("Type 'equip' and the item you want to equip.");
        System.out.println("Type 'eat' and the food from the room or your inventory that you want to eat.");
        System.out.println("Type 'attack' to attack the enemy.");
        System.out.println("Type 'help' for help (like you just did).");
        System.out.println("Type 'exit' to exit the game.\n");
    }

    public void eat(String foodName) {
        Food choosenFood =  newAdventure.playerEat(foodName);
        if (choosenFood != null) {
            System.out.println("You ate " + foodName + ".");
        } else {
            System.out.println("Could not find a food called " + foodName );
        }
    }

    public void equip(String weaponName) {
        Item equippedWeapon = newAdventure.equipWeapon(weaponName);
        if (equippedWeapon == null) {
            System.out.println("You don't have a weapon named " + weaponName + " in your inventory.");

        } else if ( !(equippedWeapon instanceof Weapon)) {
            System.out.println("You can not equip " + weaponName + ".");
        }
        else {
            System.out.println("You equipped " + weaponName + ".");
        }
    }



    public void attack() {
        Weapon equippedWeapon = newAdventure.getGamePlayer().getEquippedWeapon();
        if (equippedWeapon == null ) {
            System.out.println("You don't have a weapon equipped.");
        } else if(equippedWeapon.getRemainingUse()== 0 ) {
            System.out.println("You don't have any ammunition left.");
        }else{
            equippedWeapon.useWeapon();
            System.out.println("You attacked with " + equippedWeapon.getShortName() + " and did " + equippedWeapon.getDamagePoints() + " damage.");

        }

    }
//    public void enemyAttack(){
//        Weapon enemyWeapon = newAdventure.getEnemy().getWeapon();
//        enemyWeapon.useWeapon();
//        System.out.println(enemyWeapon.getDamagePoints());
//
//    }

    // Method to get String Input From User
    public String getStringInput() {
        try {
            String inputString = scanner.nextLine().trim().toLowerCase();
            if (inputString.isEmpty()) {
                System.out.println("That didn't work. Try again.");
                return getStringInput();
            }
            return inputString;
        } catch (InputMismatchException e) {
            System.out.println("That didn't work. Try again.");
            scanner.nextLine();
            return getStringInput();
        }
    }

}





