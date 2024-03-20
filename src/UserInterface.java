import java.util.*;


public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Adventure newAdventure = new Adventure();

    // Array of directions
    final String[] directions = new String[]{"go south", "south", "s",
            "go north", "north", "n",
            "go east", "east", "e",
            "go west", "west", "w"};

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
                case String s when directionsList.contains(s) -> changeRoom(userChoice);

                //INVENTORY
                case "inventory" -> showInventory();

                //TAKE:
                case String s when s.startsWith("take") -> takeItem(userChoice);

                //DROP
                case String s when s.startsWith("drop") -> dropItem(userChoice);

                //EAT:
                case String s when s.startsWith("eat") -> eat(userChoice);

                //EQUIP:
                case String s when s.startsWith("equip") -> equip(userChoice);

                //ATTACK
                case String s when s.startsWith("attack") -> attack(userChoice);

                case "health" -> health();
                case "look" -> look();
                case "help" -> help();
                case "exit", "exit game" -> System.out.println("Exiting game.");
                default -> System.out.println("That doesn't work.");
            }
        }
    }

    public void changeRoom(String direction) {

        if (newAdventure.moveAround(direction)) {
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


    public void showInventory() {
        System.out.println("Inventory:");
        showItemInArray(newAdventure.getGamePlayer().getInventoryArr());
        if (newAdventure.getGamePlayer().getEquippedWeapon() != null) {
            Weapon equippedWeapon = newAdventure.getGamePlayer().getEquippedWeapon();
            System.out.println("You are equipped with " + equippedWeapon.getShortName() + ".");
        }
    }

    public void takeItem(String chosenItem) {
        String itemToTake;
        if (chosenItem.trim().length() >= 5) {
            itemToTake = chosenItem.substring(4).trim();
            Item choosenItem = newAdventure.takeItem(itemToTake);
            if (choosenItem != null) {
                System.out.println("You took the " + choosenItem.getShortName() + ".");
            } else {
                System.out.println("Can not find " + itemToTake + ".");
            }
        } else {
            System.out.println("You have to write an item to take.");
        }

    }

    public void dropItem(String chosenItem) {
        String itemToDrop;

        if (chosenItem.length() >= 5) {
            itemToDrop = chosenItem.substring(4).trim();
            Item droppedItem = newAdventure.dropItem(itemToDrop);
            if (droppedItem != null) {
                System.out.println("You dropped " + droppedItem.getShortName() + ".");
            } else {
                System.out.println("You don't have anything like '" + itemToDrop + "' in you inventory.");
            }
        } else {
            System.out.println("You have to write an item to drop.");
        }

    }

    public void eat(String requestedFood) {
        String foodToEat;

        if (requestedFood.length() >= 4) {
            foodToEat = requestedFood.substring(3).trim();
            Food chosenFood = newAdventure.playerEat(foodToEat);
            if (chosenFood != null) {
                System.out.println("You ate " + foodToEat + ".");
            } else {
                System.out.println("Could not find a food called " + foodToEat);
            }

        } else {
            System.out.println("You have to write a food name to eat.");
        }


    }

    public void equip(String requestedWeapon) {
        String WeaponToEquip;

        if (requestedWeapon.length() >= 6) {
            WeaponToEquip = requestedWeapon.substring(5).trim();
            Item equippedWeapon = newAdventure.equipWeapon(WeaponToEquip);

            if (equippedWeapon == null) {
                System.out.println("You don't have a weapon named " + WeaponToEquip + " in your inventory.");

            } else if (!(equippedWeapon instanceof Weapon)) {
                System.out.println("You can not equip " + WeaponToEquip + ".");
            } else {
                System.out.println("You equipped " + WeaponToEquip + ".");
            }

        } else {
            System.out.println("You have to write a weapon to equip.");
        }


    }

    // WILL DELETE THIS LATER
//    public void attack() {
//        Weapon equippedWeapon = newAdventure.getGamePlayer().getEquippedWeapon();
//        if (equippedWeapon == null) {
//            System.out.println("You don't have a weapon equipped.");
//        } else if (equippedWeapon.getRemainingUse() == 0) {
//            System.out.println("You don't have any ammunition left.");
//        } else {
//            equippedWeapon.useWeapon();
//            System.out.println("You attacked with "
//                    + equippedWeapon.getShortName()
//                    + " and did " + equippedWeapon.getDamagePoints()
//                    + " damage.");
//        }
//    }


    // Method to check Player's remaining Health
    public void health() {
        int playerHealth = newAdventure.getGamePlayer().getHealth();
        System.out.println("Your current health is " + playerHealth + ".");

    }


    public void look() {
        StringBuilder roomInfo = new StringBuilder();
        roomInfo.append("You are in: ").append(newAdventure.getCurrentRoom().getName());
        roomInfo.append("\n").append(newAdventure.getCurrentRoom().getDescription());
        System.out.println(roomInfo);
        showItemInArray(newAdventure.getCurrentRoom().getItemsInRoomArr());
        if (!newAdventure.getCurrentRoom().getEnemiesInRoomArr().isEmpty()) {
            for (Enemy enemy : newAdventure.getCurrentRoom().getEnemiesInRoomArr()) {
                System.out.println(enemy.getName());
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


    public void attack(String wantedEnemy) {
        String enemyToFight = wantedEnemy.substring(6).trim();
        // should add a length check here

        ArrayList<Enemy> foundEnemies = newAdventure.getCurrentRoom().getEnemiesInRoomArr();
        if (foundEnemies.isEmpty()) {
            System.out.println("There are no enemies to attack");
        } else {
            for (Enemy enemy : foundEnemies) {
                if (enemy.getName().equalsIgnoreCase(enemyToFight)) {
                    Weapon equippedWeapon = newAdventure.getGamePlayer().getEquippedWeapon();
                    if (equippedWeapon == null) {
                        System.out.println("You don't have a weapon equipped.");
                    } else if (equippedWeapon.getRemainingUse() == 0) {
                        System.out.println("You don't have any ammunition left.");
                    } else {
                        equippedWeapon.useWeapon();
                        int enemyNewHealth = (enemy.getEnemyHealthPoints()) - equippedWeapon.damagePoints;
                        enemy.setEnemyHealthPoints(enemyNewHealth);
                        System.out.println("You attacked with " + equippedWeapon.getShortName() + " and did " +
                                equippedWeapon.getDamagePoints() + " damage on " + enemyToFight + " and "
                                + enemyToFight + " now has " + enemyNewHealth + " hp left");


                    }


                }
            }
        }


    }


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





