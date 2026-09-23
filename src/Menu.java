import java.util.Scanner;

public class Menu {

    static void printMenu(Scanner scanner) {
        int input;

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Начать игру:");
            System.out.println("2. Вывести список лучших результатов");
            System.out.println("3. Покинуть игру");

            input = Game.readInt(scanner, "Твой выбор: ");

            switch(input) {
                case 1: Game.printGameMenu(scanner);
                break;
                case 2: LeaderBoard.printLeaderBoard();
                break;
                case 3: System.out.println("До скорых встреч!");
                return;
            }
        }

    }

    static void additionalMenu(Scanner scanner) {

        while (true) {

            int input;

            System.out.println("Сыграем еще раз?");
            System.out.println("1. Да, вперед!:");
            System.out.println("2. Вернутся в меню");

            input = Game.readInt(scanner, "Твой выбор: ");

            switch (input) {
                case 1: Game.printGameMenu(scanner);
                break;
                case 2: Menu.printMenu(scanner);
                break;
            }
        }
    }
}

