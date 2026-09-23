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

            input = readInt(scanner, "Твой выбор: ");

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

        boolean tookHint = false;

        int number = RANDOM.nextInt(1 ,101);   // 1..100
        int attempts = difficulty.getAttempts();
        int attempt = 1;

        System.out.println("Я загадал число от 1 до 100 - угадывай!");

        while (attempt <= attempts) {
            System.out.println("Осталось попыток: " + (attempts - attempt + 1));
            int guess = readInt(scanner, "Твоя догадка (0 — подсказка): ");

            if (guess == number) {
                System.out.println("Поздравляю! Ты угадал за " + attempt + " попыток.");
                System.out.print("Введи своё имя: ");
                String name = scanner.next();
                Menu.additionalMenu(scanner);
                return;

            } else if (guess == 0) {
                if (!tookHint) {
                    System.out.println("Подсказка: число " + (number % 2 == 0 ? "чётное" : "нечётное"));
                    tookHint = true;
                } else {
                    System.out.println("Ты уже брал подсказку!");
                }
                continue;

            } else if (guess < number) {
                System.out.println("Загаданное число больше.");

            } else {
                System.out.println("Загаданное число меньше.");
            }
            attempt++;
        }

        System.out.println("Попытки кончились. Было загадано: " + number);
        Menu.additionalMenu(scanner);
    }

    public static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) return scanner.nextInt();
            System.out.println("Нужно вводить число!");
            scanner.next();
        }
    }
}
