import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Adventure newAdventure = new Adventure();


    public void playingGame() {
        System.out.println("Welcome to the game!");
        look();
        menu();
        String userChoice = " ";

        while (!userChoice.equals("exit")) {
            userChoice = getStringInput().toLowerCase();

            switch (userChoice) {
                case "south", "s", "north", "n", "east", "e", "west", "w" -> {
                    if (newAdventure.moveAround(userChoice)) {
                        look();
                        if (newAdventure.getCurrentRoom().getVisited()) {
                            System.out.println("Warning: You have been here before");
                        } else {
                            newAdventure.markVisitedRoom();
                        }
                    } else {
                        System.out.println("You cannot go that direction.");
                    }
                }
                case "look" -> look();
                case "inventory" -> {
                    System.out.println("Inventory:");
                    showItemInArray(newAdventure.getGamePlayer().getInventoryArr());
                }
                case "health" -> health();
                //TAKE:
                case String s when s.startsWith("take") -> {
                    String[] itemToTake = userChoice.split(" ");
                    takeItem(itemToTake[1]);
                }
                case String s when s.startsWith("drop") -> {
                    String[] itemToDrop = userChoice.split(" ");
                    dropItem(itemToDrop[1]);
                }
                //EAT:
                case String s when s.startsWith("eat") -> {
                    String[] foodToEat = userChoice.split(" ");
                    eat(foodToEat[1]);
                }
                //EQUIP:
                case String s when s.startsWith("equip") -> {
                    String[] WeaponToEquip = userChoice.split(" ");
                    equip(WeaponToEquip[1]);
                }
                case "attack" -> attack();
                case "help" -> help();
                case "exit", "exit game" -> System.out.println("Exiting game.");
                default -> System.out.println("Invalid choice.");
            }
        }
    }


    public String getStringInput() {
        try {
            String inputString = scanner.nextLine().trim();
            if (inputString.isEmpty()) {
                System.out.println("Invalid input. Please try again.");
                return getStringInput();
            }
            return inputString;
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine();
            return getStringInput();
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

    }

    public void showItemInArray(ArrayList<Item> playerItems) {
        if (playerItems.isEmpty()) {
            System.out.println("Empty");
        } else {
            for (Item item : playerItems) {
                System.out.println(" " + item.getShortName() + ": " + item.getLongName());
            }
        }
    }

    public void takeItem(String itemToTake) {
        Item choosenItem = (Item) newAdventure.takeItem(itemToTake);
        if (choosenItem != null) {
            System.out.println("You took the " + choosenItem.getShortName() + ".");
        } else {
            System.out.println("You don't have anything like '" + itemToTake + "' in you inventory");
        }
    }

    public void dropItem(String itemToDrop) {
        Item droppedItem = newAdventure.dropItem(itemToDrop);
        if (droppedItem != null) {
            System.out.println("You dropped " + droppedItem.getShortName() + ".");
        } else{
            System.out.println("You don't have anything like '" + itemToDrop + "' in you inventory");
        }
    }

    public void health() {
        int playerHealth = newAdventure.getGamePlayer().getHealth();
        System.out.println("Your current health: " + playerHealth);

    }


    public void help() {
        System.out.println("Type: 'north', 'south', 'east' or 'west' to choose direction.");
        System.out.println("Type: 'look' to look around the room you're currently in.");
        System.out.println("Type: 'inventory' to see what's in your inventory");
        System.out.println("Type: 'health' to see your health score");
        System.out.println("Type: 'take' and the item you want to take from the room you're in");
        System.out.println("Type: 'drop' and the item frem your inventory you want to drop");
        System.out.println("Type: 'equip' and the item you want to equip");
        System.out.println("Type: 'eat' and the food from the room or your inventory that you want to eat");
        System.out.println("Type: 'attack' to attack the enemy");
        System.out.println("Type: 'help' for help (like you just did)");
        System.out.println("Type: 'exit' to exit the game.\n");
    }

    public void eat(String foodName) {
        Food choosenFood = (Food) newAdventure.playerEat(foodName);
        if (choosenFood != null) {
            System.out.println("You ate " + foodName);
        } else {
            System.out.println("Couldn't find this food try again!!");
        }
    }

    public void equip(String weaponName) {
        Weapon equippedWeapon = newAdventure.equipWeapon(weaponName);
        if (equippedWeapon != null) {
            System.out.println("You equipped the: " + weaponName + ".");
        } else {
            System.out.println("You don't have a weapon named: " + weaponName + " in your inventory.");
        }
    }


    public void attack() {
        System.out.println("Choose a weapon to attack with: ");
        String weaponName = getStringInput();
        Weapon equippedWeapon = newAdventure.getGamePlayer().getEquippedWeapon();
        if (equippedWeapon == null ) {
            System.out.println("You don't have a weapon equipped.");
        } else if (!equippedWeapon.getShortName().equalsIgnoreCase(weaponName)) {
            System.out.println("You don't a " +weaponName+ "in your inventory ");
        } else if(equippedWeapon.getRemainingUse()== 0 ) {
            System.out.println("You don't have ammunition");
        }else{
            equippedWeapon.useWeapon();
            System.out.println("You attacked with " + equippedWeapon.getShortName() + ".");
        }

    }

}





