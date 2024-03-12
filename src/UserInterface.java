import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Adventure newAdventure = new Adventure();




    public void playingGame() {
        System.out.println("Welcome to the game!");
        System.out.println(look());
        showInventory(newAdventure.getGamePlayer().getInventoryArr());
        int userChoice = 0;

        while (userChoice != 7) {
            menu();
            userChoice = getInteger(1,7);

            switch (userChoice) {
                //Choose direction:
                case 1 -> {
                    String direction = choosingDirection();
                    if (newAdventure.moveAround(direction)){
                        System.out.println(newAdventure.getCurrentRoom().getDescription());
                        // add show room items here
                    }else {
                        System.out.println("you can not go that direction ");
                    }
                }
                //Look:
                case 2 -> {
                    System.out.println(look());
                }
                //Inventory:
                case 3 -> {
                    showInventory(newAdventure.getGamePlayer().getInventoryArr());
                }
                //Help:
                case 4 -> {
                    help();
                }
                //Take:
                case 5 -> {
                    showInventory(newAdventure.inventory());
                    System.out.print("Enter the item name to take: ");
                    String itemToTake = scanner.nextLine();
                    Item pickedItem = newAdventure.takeItem(itemToTake);
                    System.out.println("You took the " + pickedItem.getShortName() + ".");
                    System.out.println("There is nothing like " + itemToTake + " to take around here.");

                }
                //Drop:
                case 6 -> {
                    System.out.print("Enter the item name to drop: ");
                    String itemToDrop = scanner.nextLine();
                    Item droppedItem = newAdventure.dropItem(itemToDrop);
                    newAdventure.dropItem(itemToDrop);
                    System.out.println("You dropped the " + droppedItem.getShortName() + ".");
                    System.out.println("You don't have anything like " + itemToDrop + " in your inventory.");
                }
                //Exit:
                case 7 -> {
                    System.out.println("Exit game");
                }
                default -> {
                    System.out.println("Invalid choice");
                }
            }

        }
    }

    // add get string here to get the direction from user
    public String choosingDirection() {
        System.out.println("Choose direction");
        scanner.nextLine();
        String userDirection = scanner.nextLine();
        userDirection = userDirection.toLowerCase();
        return userDirection;
    }



    // look methode skal vise room items ogsa
    public String look() {
        StringBuilder roomInfo = new StringBuilder();
        roomInfo.append("You are in: ").append(newAdventure.getCurrentRoom().getName());
        roomInfo.append("\n").append(newAdventure.getCurrentRoom().getDescription());
        return roomInfo.toString();
    }

    public void help() {
        System.out.println("Type 1 to choose which direction you wish to go in: North, South, East or West.");
        System.out.println("Type 2 to look around the room you're currently in.");
        System.out.println("Type 3 for help (like you just did)");
        System.out.println("Type 4 for inventory");
        System.out.println("Type 5 to take an item");
        System.out.println("Type 6 to drop an item");
        System.out.println("Type 7 to exit the game.");
    }

    public void menu() {
        System.out.println("1. Chose direction");
        System.out.println("2. Look");
        System.out.println("3. Inventory");
        System.out.println("4. Help");
        System.out.println("5. Take");
        System.out.println("6. Drop");
        System.out.println("7. Exit game");
    }

    public void showInventory(ArrayList<Item> playerItems) {
        System.out.println("Inventory: ");
        for (Item item : playerItems) {
            System.out.println(" " + item.getShortName());

        }
    }

    public String getStringInput(){
        try {
            String inputString = scanner.nextLine();

            return inputString;

        }
        catch (InputMismatchException e){
            System.out.println("wrong input try again!");
            return getStringInput();
        }
    }

    public int getInteger(int start, int end){
        try {
            int inputNumber = scanner.nextInt();

           if (inputNumber < start || inputNumber > end ){
               System.out.println("wrong number, try again!!");
               return getInteger(start, end);
           }else {
               return inputNumber;
           }

        }
        catch (InputMismatchException e){
            System.out.println("wrong input try again!");
            return getInteger(start, end);
        }
    }


}
