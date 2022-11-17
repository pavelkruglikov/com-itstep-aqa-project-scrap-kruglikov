import java.sql.*;
import java.util.Scanner;
import java.sql.Date;

public class AdminAccess {

    boolean endFlag = true;
    Scanner scanner = new Scanner(System.in);
    ConnectionToDB connectionToDB = new ConnectionToDB();
    Connection connection = connectionToDB.connection;

    public static java.sql.Timestamp convert(java.util.Date date) {
        return new java.sql.Timestamp(date.getTime());

    }

    public void showMenu() {
        System.out.println("1. Добавить приемку");
        System.out.println("2. Посмотреть список приемок");
        System.out.println("3. Изменить приемку");
        System.out.println("4. Удалить приемку");
        System.out.println("5. Выход");
    }

    public int getMenuPointer() {
        System.out.println("Введите команду: ");
        return scanner.nextInt();
    }

    public void controller() throws SQLException {
        showMenu();
        int command = getMenuPointer();
        switch (command) {
            case 1: {
                addAcceptance();
                break;
            }
            case 2: {
                showListOfAcceptations();
                break;
            }
            case 3: {
                changeAcceptance();
                break;
            }
            case 5: {
                endFlag = false;
            }
            default: System.err.println("Неправильная команда");
            break;

        }
    }

    public void showListOfAcceptations() throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_ACCEPTANCE = "select * from \"acceptanceScrap\" order by acceptance_id";
        ResultSet result = statement.executeQuery(SQL_SHOW_ACCEPTANCE);
        while (result.next()) {
            System.out.println(result.getInt("acceptance_id") + " " + result.getString("supplier") + " "
            + result.getDouble("gross_weight") + " " + result.getDouble("container_weight")  + " " + result.getDouble("net_weight") + " "
                    + result.getDouble("price_per_kg") + " " + result.getDouble("total_payment")+ " " +
                    result.getString("acceptor") + " " + result.getString("acceptance_date"));
        }
        System.out.println();
    }

    public void changeAcceptance()throws SQLException{
        String sql = "update acceptanceScrap set supplier = ?, gross_weight = ?," +
                "container_weight = ?,net_weight = ?, price_per_kg = ?, total_payment = ?, " +
                "acceptor =? ,acceptance_date = ? where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("Введите ID изменяемой приемки: ");
        int acceptanceID = scanner.nextInt();
        preparedStatement.setInt(9,acceptanceID);
        System.out.println("Введите поставщика: ");
        scanner.nextLine();
        String supplier = scanner.nextLine();
        preparedStatement.setString(1, supplier);
        System.out.println("Введите общий вес: ");
        Double grossWeight = scanner.nextDouble();
        preparedStatement.setDouble(2, grossWeight);
        System.out.println("Введите вес тары: ");
        Double container = scanner.nextDouble();
        preparedStatement.setDouble(3, container);
        Double netWeight = grossWeight - container;
        preparedStatement.setDouble(4, netWeight);
        System.out.println("Введите цену за кг: ");
        Double pricePerKG = scanner.nextDouble();
        preparedStatement.setDouble(5, pricePerKG);
        Double totalPayment = netWeight * pricePerKG;
        preparedStatement.setDouble(6, totalPayment);
        System.out.println("Введите приемщика: ");
        scanner.nextLine();
        String acceptor = scanner.nextLine();
        preparedStatement.setString(7, acceptor);
        System.out.println("Введите дату ГГГГ-ММ-ЧЧ: ");
        String date = scanner.nextLine();
        preparedStatement.setString(8, date);
        scanner.nextLine();
        preparedStatement.executeUpdate();
    }


    public void addAcceptance() throws SQLException {
        String sql = "insert into \"acceptanceScrap\" (supplier, gross_weight," +
                "container_weight,net_weight, price_per_kg, total_payment, acceptor, acceptance_date) values (?,?,?,?,?,?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("Введите поставщика: ");
        scanner.nextLine();
        String supplier = scanner.nextLine();
        preparedStatement.setString(1, supplier);
        System.out.println("Введите общий вес: ");
        Double grossWeight = scanner.nextDouble();
        preparedStatement.setDouble(2, grossWeight);
        System.out.println("Введите вес тары: ");
        Double container = scanner.nextDouble();
        preparedStatement.setDouble(3, container);
        Double netWeight = grossWeight - container;
        preparedStatement.setDouble(4, netWeight);
        System.out.println("Введите цену за кг: ");
        Double pricePerKG = scanner.nextDouble();
        preparedStatement.setDouble(5, pricePerKG);
        Double totalPayment = netWeight * pricePerKG;
        preparedStatement.setDouble(6, totalPayment);
        System.out.println("Введите приемщика: ");
        scanner.nextLine();
        String acceptor = scanner.nextLine();
        preparedStatement.setString(7, acceptor);
        System.out.println("Введите дату ГГГГ-ММ-ЧЧ: ");
        String date = scanner.nextLine();
        preparedStatement.setString(8, date);
        preparedStatement.executeUpdate();
    }

}



