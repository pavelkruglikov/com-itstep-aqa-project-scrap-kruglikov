import java.sql.*;
import java.util.Scanner;

public class AcceptorMenu {

    boolean endFlag = true;
    Scanner scanner = new Scanner(System.in);


    public void showMenu() {
        System.out.println("1. Добавить приемку");
        System.out.println("2. Посмотреть список приемок");
        System.out.println("3. Выход");
    }

    public String getMenuPointer() {
        System.out.println("\nВведите команду: ");
        return scanner.nextLine();
    }

    public void controller() throws SQLException {
        OperationWithAcceptanceScrap operation = new OperationWithAcceptanceScrap();
        showMenu();
        String command = getMenuPointer();
        switch (command) {
            case "1" -> {
                operation.addAcceptance();
            }
            case "2" -> {
                operation.showListOfAcceptations();
            }

            case "3" -> {
                endFlag = false;
                System.exit(0);
            }
            default -> System.err.println("Неправильная команда");
        }
    }

}