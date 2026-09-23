import java.util.Random;
import java.util.Scanner;

public class Game {

    private static final Random RANDOM = new Random();

    static Difficulty printGameMenu(Scanner scanner) {
        while (true) {
            System.out.println("Выбери сложность:");
            System.out.println("1. Легкая (10 попыток)");
            System.out.println("2. Средняя (5 попыток)");
            System.out.println("3. Сложная (3 попытки)");

            int input = readInt(scanner, "Твой выбор: ");

            switch (input) {
                case 1: return Difficulty.EASY;
                case 2: return Difficulty.MEDIUM;
                case 3: return Difficulty.HARD;
                default: System.out.println("Введи 1, 2 или 3.");
            }
        }
    }

    static void startGame(Difficulty difficulty, Scanner scanner) {
        boolean tookHint = false;
        int number = RANDOM.nextInt(1, 101);
        int attempts = difficulty.getAttempts();
        int attempt = 1;

        System.out.println("Я загадал число от 1 до 100 — угадывай!");

        while (attempt <= attempts) {
            System.out.println("Осталось попыток: " + (attempts - attempt + 1));
            int guess = readInt(scanner, "Твоя догадка (0 — подсказка): ");

            if (guess == number) {
                System.out.println("Поздравляю! Ты угадал за " + attempt + " попыток.");
                System.out.print("Введи своё имя: ");
                String name = scanner.next();
                LeaderBoard.submit(name, attempt, difficulty);
                return;   // <-- просто выходим, никаких additionalMenu

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