import java.sql.SQLException;
import java.util.Scanner;

public class UserControlMenu {
    boolean endFlag = true;
    Scanner scanner = new Scanner(System.in);

    void showUserOperationMenu() {
        System.out.println("1. Добавить пользователя");
        System.out.println("2. Список пользователей");
        System.out.println("3. Изменить пользователя");
        System.out.println("4. Удалить пользователя");
        System.out.println("5. В главное меню");
    }

    public String getMenuPointer() {
        System.out.println("\nВведите команду: ");
        return scanner.nextLine();
    }

    void userMenuController() throws SQLException {
        OperationWithUserList operationWithUserList = new OperationWithUserList();
        showUserOperationMenu();
        String commandInUser = getMenuPointer();

        switch (commandInUser) {
            case "1" -> {
                operationWithUserList.addUser();
            }
            case "2" -> {
                operationWithUserList.showUserInformation();

            }
            case "3" -> {
                operationWithUserList.changeUserInformation();
            }
            case "4" -> {
                operationWithUserList.deleteUser();
            }
            case "5" -> {
                endFlag = false;
            }
            default -> System.err.println("Неправильная команда");
        }
    }
}
