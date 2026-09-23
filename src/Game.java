import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Game {

    private static final Random RANDOM = new Random();

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

        int number = RANDOM.nextInt(1 ,101);   // 1..100
        int attempts = difficulty.getAttempts();

        System.out.println("Я загадал число от 1 до 100 - угадывай!");
        for (int i = 0; i < attempts; i++) {
            System.out.println("Осталось попыток: " + (attempts - i));
            int guess = readInt(scanner, "Твоя догадка: ");

            if (guess == number) {
                System.out.println("Поздравляю! Ты угадал за " + (i + 1) + " попыток.");
                System.out.print("Введи своё имя: ");
                String name = scanner.next();
                Menu.additionalMenu(scanner);
                return;

            } else if (guess < number) {
                System.out.println("Загаданное число больше.");
            } else {
                System.out.println("Загаданное число меньше.");
            }
        }

        System.out.println("Попытки кончились. Было загадано: " + number);
        Menu.additionalMenu(scanner);
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) return scanner.nextInt();
            System.out.println("Нужно вводить число!");
            scanner.next();
        }
    }
}
