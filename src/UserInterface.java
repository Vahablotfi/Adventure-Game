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
        String userChoice;

        do {
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
                case "take" -> {
                    System.out.println("Items in this room:");
                    showItemInArray(newAdventure.getCurrentRoom().getItemsInRoomArr());
                    System.out.print("Enter the item name to take: ");
                    String itemToTake = getStringInput();
                    Item pickedItem = newAdventure.takeItem(itemToTake);
                    if (pickedItem != null) {
                        System.out.println("You took the " + pickedItem.getShortName() + ".");
                    } else {
                        System.out.println("There is nothing like " + itemToTake + " to take around here.");
                    }
                }
                case "drop" -> {
                    System.out.println("Inventory:");
                    showItemInArray(newAdventure.getGamePlayer().getInventoryArr());
                    System.out.print("Enter the item name to drop: ");
                    String itemToDrop = getStringInput();
                    Item droppedItem = newAdventure.dropItem(itemToDrop);
                    if (droppedItem != null) {
                        System.out.println("You dropped the " + droppedItem.getShortName() + ".");
                    } else {
                        System.out.println("You don't have anything like " + itemToDrop + " in your inventory.");
                    }
                }
                case "eat" -> eat();
                case "equip" -> {
                    System.out.println("Enter name of the weapon to equip: ");
                    String weaponName = getStringInput();
                    Weapon equippedWeapon = newAdventure.equipWeapon(weaponName);
                    if (equippedWeapon != null) {
                        System.out.println("You equipped the: " + equippedWeapon.getShortName() + ".");
                    } else {
                        System.out.println("You don't have a weapon named: " + weaponName + " in your inventory.");
                    }
                }
                case "attack" -> {
                    System.out.println("Choose a weapon to attack with: ");
                    String weaponName = getStringInput();
                    Weapon equippedWeapon = newAdventure.getEquippedWeapon();
                    if (equippedWeapon != null && equippedWeapon.getShortName().equalsIgnoreCase(weaponName)) {
                        System.out.println("You attacked with " + equippedWeapon.getShortName() + ".");
                    } else {
                        System.out.println("You don't have a weapon named " + weaponName + " equipped.");
                    }
                }
                case "help" -> help();
                case "exit", "exit game" -> System.out.println("Exiting game.");
                default -> System.out.println("Invalid choice.");
            }
        } while (!userChoice.equals("exit"));
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
        printItemsInCurrentRoom();

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

    public void health() {
        int playerHealth = newAdventure.getGamePlayer().getHealth();
        System.out.println("Your current health: " + playerHealth);

    }


    public void eat() {
        for (Item playerItems : newAdventure.getGamePlayer().getInventoryArr()) {
            if (playerItems instanceof Food) {
                System.out.println(playerItems.getShortName());
            }
        }

        for (Item roomItems : newAdventure.getCurrentRoom().getItemsInRoomArr()) {
            if (roomItems instanceof Food) {
                System.out.println(roomItems.getShortName());
            }
        }
        System.out.println("Choose a food to eat or take: ");
        String playersChoise = getStringInput();
        System.out.println("Choose to either eat or take food ");
        String command = getStringInput();
        Food choosenFood = (Food) newAdventure.playerEat(command, playersChoise);
        if (choosenFood != null) {
            System.out.println("You " + command + " " + playersChoise);
        } else {
            System.out.println("Couldn't find this food try again!!");
        }

    }

    public void help() {
        System.out.println("Type: north, south, east or west to choose direction.");
        System.out.println("Type: 'look' to look around the room you're currently in.");
        System.out.println("Type: 'inventory' to see what's in your inventory");
        System.out.println("Type: 'health' to see your health score");
        System.out.println("Type: 'take' to choose an item to take from the room you're in");
        System.out.println("Type: inventory to choose an item from your inventory to drop");
        System.out.println("Type: 'equip'");
        System.out.println("Type: 'eat' to eat something from the room your in");
        System.out.println("Type: 'attack' to attack the enemy");
        System.out.println("Type: 'help' for help (like you just did)");
        System.out.println("Type: 'exit' to exit the game.\n");
    }


    public void printItemsInCurrentRoom() {
        System.out.println("Items in this room:");
        ArrayList<Item> items = newAdventure.getCurrentRoom().getItemsInRoomArr();
        for (Item item : items) {
            System.out.println(item.getShortName());
        }
    }

}





