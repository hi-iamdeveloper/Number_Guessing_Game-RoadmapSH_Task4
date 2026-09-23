import java.util.Scanner;

void main() {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Добро пожаловать в игру угадай цифру!");
    System.out.println("Я загадаю цифру от 1 до 100, а твоя задача - ее угадать! \n");

    Menu.printMenu(scanner);


}

