import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Adventure adventure = new Adventure(); //instance/objekt


    public void startGame() {
        System.out.println("Welcome to the game!");
        System.out.println("Game description");
        int userChoice = 0;

        while (userChoice != 4) {
            System.out.println("1. Chose direction");
            System.out.println("2. Look");
            System.out.println("3. Help");
            System.out.println("4. Exit game");
            userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    System.out.println("Chose direction");
                    chooseDirection();
                    break;
                case 2:
                    System.out.println(adventure.getCurrentRoom().getName());
                    break;
                case 3:
                    System.out.println("Help");
                    break;
                case 4:
                    System.out.println("Exit game");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public void chooseDirection() {
        scanner.nextLine();
        String userDirection = scanner.nextLine();
        userDirection = userDirection.toLowerCase();
        Room currentRoom = adventure.getCurrentRoom();
        switch (userDirection) {
            case "go north":
            case "n":
            case "north":
                if (currentRoom.getNorth() == null) {
                    System.out.println("you can't go in that direction");
                } else {
                    adventure.setCurrentRoom(adventure.getCurrentRoom().getNorth());
                    System.out.println(adventure.getCurrentRoom().getName());
                }
                break;
            case "go south":
            case "s":
            case "south":
                if (currentRoom.getSouth() == null) {
                    System.out.println("you can't go in that direction");
                } else {
                    adventure.setCurrentRoom(adventure.getCurrentRoom().getSouth());
                    System.out.println(adventure.getCurrentRoom().getName());
                }
                break;
            case "go east":
            case "e":
            case "east":
                if (currentRoom.getEast() == null) {
                    System.out.println("you can't go in that direction");
                } else {
                    adventure.setCurrentRoom(adventure.getCurrentRoom().getEast());
                    System.out.println(adventure.getCurrentRoom().getName());
                }
                break;
            case "go west":
            case "w":
            case "west":
                if (currentRoom.getWest() == null) {
                    System.out.println("you can't go in that direction");
                } else {
                    adventure.setCurrentRoom(adventure.getCurrentRoom().getWest());
                    System.out.println(adventure.getCurrentRoom().getName());
                }
                break;

        }

    }


}
