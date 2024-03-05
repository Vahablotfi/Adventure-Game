import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);

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
                    break;
                case 2:
                    System.out.println("Look");
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
}
