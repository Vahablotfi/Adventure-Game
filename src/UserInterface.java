import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Adventure newAdventure = new Adventure();


    public void playingGame() {
        System.out.println("Welcome to the game!");
        look();
        int userChoice = 0;

        while (userChoice != 7) {
            menu();
            userChoice = getInteger(1, 7);

            switch (userChoice) {
                //Choose direction:
                case 1 -> {
                    String direction = choosingDirection();
                    if (newAdventure.moveAround(direction)) {
                        look();
                        if (newAdventure.getCurrentRoom().getVisited()) {
                            System.out.println("Warning: You have been here before");
                        } else {
                            newAdventure.markVisitedRoom();
                        }
                    } else {
                        System.out.println("you can not go that direction ");
                    }
                }
                //look:
                case 2 -> {
                    look();
                }
                //Inventory:
                case 3 -> {
                    showInventory(newAdventure.getGamePlayer().getInventoryArr());
                }
                //Health:
                case 4 -> {
                    health();
                }
                //Help:
                case 5 -> {
                    help();
                }
                //Take:
                case 6 -> {
                    showInventory(newAdventure.getCurrentRoom().getItemsInRoomArr());
                    System.out.print("Enter the item name to take: ");
                    String itemToTake = getStringInput();
                    Item pickedItem = newAdventure.takeItem(itemToTake);
                    if (pickedItem != null) {
                        System.out.println("You took the " + pickedItem.getShortName() + ".");
                    } else {
                        System.out.println("There is nothing like " + itemToTake + " to take around here.");
                    }
                }
                //Drop:
                case 7 -> {
                    System.out.print("Enter the item name to drop: ");
                    String itemToDrop = getStringInput();
                    Item droppedItem = newAdventure.dropItem(itemToDrop);
                    if (droppedItem != null) {
                        System.out.println("You dropped the " + droppedItem.getShortName() + ".");
                    } else {
                        System.out.println("You don't have anything like " + itemToDrop + " in your inventory.");
                    }
                }
                //Eat:
                case 8 -> {
                    eat();
                }
                //Exit:
                case 9 -> {
                    System.out.println("Exit game");
                }
                default -> {
                    System.out.println("Invalid choice");
                }
            }

        }
    }

    public String choosingDirection() {
        System.out.println("Choose direction");
        String userDirection = getStringInput();
        userDirection = userDirection.toLowerCase();
        return userDirection;
    }


    public void look() {
        StringBuilder roomInfo = new StringBuilder();
        roomInfo.append("You are in: ").append(newAdventure.getCurrentRoom().getName());
        roomInfo.append("\n").append(newAdventure.getCurrentRoom().getDescription());
        System.out.println(roomInfo.toString());
        printItemsInCurrentRoom();

    }

    public void help() {
        System.out.println("Type 1 to choose which direction you wish to go in: North, South, East or West.");
        System.out.println("Type 2 to look around the room you're currently in.");
        System.out.println("Type 3 to see player's inventory");
        System.out.println("Type 4 to see your health");
        System.out.println("Type 5 for help (like you just did)");
        System.out.println("Type 6 to take an item");
        System.out.println("Type 7 to drop an item");
        System.out.println("Type 8 to eat");
        System.out.println("Type 9 to exit the game.");
    }

    public void menu() {
        System.out.println("1. Chose direction");
        System.out.println("2. Look");
        System.out.println("3. Inventory");
        System.out.println("4. Health");
        System.out.println("5. Help");
        System.out.println("6. Take");
        System.out.println("7. Drop");
        System.out.println("8. Eat");
        System.out.println("9. Exit game");

    }

    public void showInventory(ArrayList<Item> playerItems) {
        if (playerItems.isEmpty()) {
            System.out.println("You have nothing, better to pick a weapon.");
        } else {
            System.out.println("Inventory: ");
            for (Item item : playerItems) {
                System.out.println(" " + item.getShortName() + ": " + item.getLongName());
            }
        }
    }

    public void health() {

    }

    public void eat() {

    }

    public String getStringInput() {
        try {
            String inputString = scanner.nextLine();
            if (inputString.trim().isEmpty()) {
                System.out.println("wrong input try again");
                return getStringInput();
            } else {
                return inputString;
            }

        } catch (InputMismatchException e) {
            System.out.println("wrong input try again!");
            scanner.nextLine();
            return getStringInput();
        }
    }

    public int getInteger(int start, int end) {
        try {
            int inputNumber = scanner.nextInt();
            scanner.nextLine();

            if (inputNumber < start || inputNumber > end) {
                System.out.println("wrong number, try again!!");
                return getInteger(start, end);
            } else {
                return inputNumber;
            }

        } catch (InputMismatchException e) {
            System.out.println("wrong input try again!");
            scanner.nextLine();
            return getInteger(start, end);
        }
    }

    public void printItemsInCurrentRoom() {
        System.out.println("Items in this room:");
        ArrayList<Item> items = newAdventure.getCurrentRoom().getItemsInRoomArr();
        for (Item item : items) {
            System.out.println(item.getLongName());
        }
    }


}
