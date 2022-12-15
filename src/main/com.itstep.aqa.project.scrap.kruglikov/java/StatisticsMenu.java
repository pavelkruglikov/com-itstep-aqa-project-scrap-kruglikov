import java.sql.SQLException;
import java.util.Scanner;

public class StatisticsMenu {
    boolean endFlag = true;
    Scanner scanner = new Scanner(System.in);

    void showStatisticsMenu() {
        System.out.println("1. Сгруппировать по поставщикам");
        System.out.println("2. Сгруппировать по приемщикам");
        System.out.println("3. Общий результат");
        System.out.println("4. Список по дате");
        System.out.println("5. В главное меню");
    }

    public String getMenuPointer() {
        System.out.println("\nВведите команду: ");
        return scanner.nextLine();
    }

    void statisticsMenuController() throws SQLException {
        StatisticOperation statisticOperation = new StatisticOperation();
        showStatisticsMenu();
        String commandInUser = getMenuPointer();

        switch (commandInUser) {
            case "1" -> {
                statisticOperation.showListOfAcceptationsGroupBySupplier();
            }
            case "2" -> {
                statisticOperation.showListOfAcceptationsGroupByAcceptor();
            }
            case "3" -> {
                statisticOperation.showTotalInformation();
            }
            case "4" -> {
                statisticOperation.showAcceptationInformationByDate();
            }
            case "5" -> {
                endFlag = false;
            }
            default -> System.err.println("Неправильная команда");
        }
    }
}

