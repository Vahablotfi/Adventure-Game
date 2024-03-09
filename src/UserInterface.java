import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Adventure newAdventure = new Adventure();


    public void startGame() {
        playGame(newAdventure.getGamePlayer());
    }

    public void playGame(Player player) {
        System.out.println("Welcome to the game!");
        System.out.println("You wake up on a dirty floor. You're in room 1!");
        int userChoice = 0;

        while (userChoice != 4) {
            menu();
            userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1:
                    if (player.moveAround(chooseDirection())) {
                        System.out.println(player.getCurrentRoom().getName());
                        System.out.println(player.getCurrentRoom().getVisited());
                        System.out.println(player.getCurrentRoom().getItemsInRoomArr());
                        System.out.println();
                    } else {
                        System.out.println("You can not go to that direction !!");
                    }
                    break;
                case 2:
                    System.out.println(player.look());
                    break;
                case 3:
                    help();
                    break;
                case 4:
                    showInventory(player);
                    break;
                case 5:
                    System.out.print("Enter the item name to take: ");
                    String itemToTake = scanner.nextLine();
                    player.takeItem(itemToTake);
                    break;
                case 6:
                    System.out.print("Enter the item name to drop: ");
                    String itemToDrop = scanner.nextLine();
                    player.dropItem(itemToDrop);
                    break;
                case 7:
                    System.out.println("Exit game");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public String chooseDirection() {
        System.out.println("Choose direction");
        scanner.nextLine();
        String userDirection = scanner.nextLine();
        userDirection = userDirection.toLowerCase();
        return userDirection;
    }

    public void help() {
        System.out.println("Type 1 to chose which direction you wish to go in: North, South, East or West.");
        System.out.println("Type 2 to look around the room you're currently in.");
        System.out.println("Type 3 for help (like you just did)");
        System.out.println("Type 4 for inventory");
        System.out.println("Type 8 to exit the game.");
    }

    public void menu() {
        System.out.println("1. Chose direction");
        System.out.println("2. Look");
        System.out.println("3. Help");
        System.out.println("4. Inventory");
        System.out.println("5. Exit game");
    }

    public void showInventory(Player player) {
        System.out.println("Inventory: ");
        for (Item item : player.getCurrentRoom().getItemsInRoomArr()) {
            System.out.println(" " + item.getShortName());

        }

    }
}
