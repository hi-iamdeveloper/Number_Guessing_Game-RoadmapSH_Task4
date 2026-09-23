import java.util.Scanner;

public class Menu {

    static void printMenu(Scanner scanner) {
        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Начать игру");
            System.out.println("2. Вывести список лучших результатов");
            System.out.println("3. Покинуть игру");

            int input = Game.readInt(scanner, "Твой выбор: ");

            switch (input) {
                case 1:
                    playRounds(scanner);
                    break;
                case 2:
                    LeaderBoard.print();
                    break;
                case 3:
                    System.out.println("До скорых встреч!");
                    return;
                default:
                    System.out.println("Введи 1, 2 или 3.");
            }
        }
    }

    private static void playRounds(Scanner scanner) {
        while (true) {
            Difficulty difficulty = Game.printGameMenu(scanner);
            Game.startGame(difficulty, scanner);

            // отдельный цикл — переспрашиваем, пока не получим 1 или 2
            while (true) {
                System.out.println("Сыграем ещё раз?");
                System.out.println("1. Да, вперёд!");
                System.out.println("2. Вернуться в меню");

                int again = Game.readInt(scanner, "Твой выбор: ");

                if (again == 1) {
                    break;          // выходим из внутреннего цикла → новая партия
                } else if (again == 2) {
                    return;         // в главное меню
                } else {
                    System.out.println("Введи 1 или 2.");
                    // внутренний цикл продолжается → снова вопрос
                }
            }
        }
    }
}