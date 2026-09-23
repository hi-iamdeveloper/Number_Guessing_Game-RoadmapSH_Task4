import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    static void printMenu(Scanner scanner) {
        int input;
        boolean running = true;

        while (running) {
            System.out.println("Меню:");
            System.out.println("1. Начать игру:");
            System.out.println("2. Вывести список лучших результатов");
            System.out.println("3. Покинуть игру");
            System.out.println("Твой выбор: ");

            try {
                input = scanner.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Нужно вводить число!");
                scanner.next();
                continue;
            }

            switch(input) {
                case 1: {
                    Game.printGameMenu(scanner);
                }

                case 2: {

                }
            }
        }

    }
}
