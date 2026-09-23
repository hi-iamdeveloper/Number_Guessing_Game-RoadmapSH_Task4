import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Game {

    static void printGameMenu(Scanner scanner) {

        int input;

        while (true) {
            System.out.println("Выбери сложность:");
            System.out.println("1. Легкая (10 попыток):");
            System.out.println("2. Средняя (5 попыток)");
            System.out.println("3. Сложная (3 попытки)");

            try {
                input = scanner.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Нужно вводить число!");
                scanner.next();
                continue;
            }

            switch (input) {
                case 1: Game.startGame(Difficulty.EASY, scanner);
                break;
                case 2: Game.startGame(Difficulty.MEDIUM, scanner);
                break;
                case 3: Game.startGame(Difficulty.HARD, scanner);
                break;
                default: System.out.println("Введите корректное число!");
            }
        }
    }

    static void startGame(Difficulty difficulty, Scanner scanner) {

        Random random = new Random();
        int number = random.nextInt(1, 101);   // 1..100

        int attempts = difficulty.getAttempts();

        for(int i = 0; i < attempts; i++) {
            System.out.println("Я загадал число от 1 до 100 - угадывай!");
        }
    }
}
