import java.sql.*;
import java.util.Scanner;

public class AdminMenu {

    boolean endFlag = true;
    Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("1. Добавить приемку");
        System.out.println("2. Посмотреть список приемок");
        System.out.println("3. Изменить приемку");
        System.out.println("4. Удалить приемку");
        System.out.println("5. Статистика");
        System.out.println("6. Управление пользователями");
        System.out.println("7. Выход");
    }


    public String getMenuPointer() {
        System.out.println("\nВведите команду: ");
        return scanner.nextLine();
    }

    public void controller() throws SQLException {
        OperationWithAcceptanceScrap operationWithAcceptanceScrap = new OperationWithAcceptanceScrap();
        showMenu();
        String command = getMenuPointer();
        switch (command) {
            case "1": {
                operationWithAcceptanceScrap.addAcceptance();
                break;
            }
            case "2": {
                operationWithAcceptanceScrap.showListOfAcceptations();
                break;
            }
            case "3": {
                operationWithAcceptanceScrap.changeAcceptance();
                break;
            }
            case "4": {
                operationWithAcceptanceScrap.deleteAcceptance();
                break;
            }
            case "5": {
                StatisticsMenu statisticsMenu = new StatisticsMenu();
                do{
                    statisticsMenu.statisticsMenuController();
                }while (statisticsMenu.endFlag);
                break;
            }
            case "6": {
                UserControlMenu userControlMenu = new UserControlMenu();
                do {
                    userControlMenu.userMenuController();
                }
                while (userControlMenu.endFlag);
                break;
            }
            case "7": {
                endFlag = false;
                System.exit(0);
            }
            default:
                System.err.println("Неправильная команда");
        }
    }


}



