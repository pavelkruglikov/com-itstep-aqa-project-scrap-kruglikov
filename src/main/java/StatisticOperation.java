import java.sql.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class StatisticOperation {
    Scanner scanner = new Scanner(System.in);
    ConnectionToDB connectionToDB = new ConnectionToDB();
    Connection connection = connectionToDB.connection;

    public void showListOfAcceptationsGroupBySupplier() throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_SUPPLIER_ACCEPTANCE = "select distinct supplier, sum(net_weight) as total_weight, " +
                "sum(total_payment) as total_payment from acceptanceScrap group by supplier";
        ResultSet result = statement.executeQuery(SQL_SHOW_SUPPLIER_ACCEPTANCE);
        while (result.next()) {
            String formattedDouble = new DecimalFormat("#0.00").format(result.getDouble("total_payment") / result.getDouble("total_weight"));
            System.out.println(result.getString("supplier") + " " + result.getDouble("total_weight") + " " +
                    formattedDouble + " " + result.getDouble("total_payment"));

        }
        System.out.println();
    }

    public void showListOfAcceptationsGroupByAcceptor() throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_ACCEPTOR_ACCEPTANCE = "select distinct acceptor, sum(net_weight) as total_weight, " +
                "sum(total_payment) as total_payment from acceptanceScrap group by acceptor";
        ResultSet result = statement.executeQuery(SQL_SHOW_ACCEPTOR_ACCEPTANCE);
        while (result.next()) {
            String formattedDouble = new DecimalFormat("#0.00").format(result.getDouble("total_payment") / result.getDouble("total_weight"));
            System.out.println(result.getString("acceptor") + " " + result.getDouble("total_weight") + " " +
                    formattedDouble + " " + result.getDouble("total_payment"));

        }
        System.out.println();
    }

    public void showTotalInformation() throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_ACCEPTOR_ACCEPTANCE = "select sum(net_weight) as total_weight, " +
                "sum(total_payment) as total_payment from acceptanceScrap";
        ResultSet result = statement.executeQuery(SQL_SHOW_ACCEPTOR_ACCEPTANCE);
        while (result.next()) {
            String formattedDouble = new DecimalFormat("#0.00").format(result.getDouble("total_payment") / result.getDouble("total_weight"));
            System.out.println("Всего принято: " + result.getDouble("total_weight") + " по средней цене: " +
                    formattedDouble + " на сумму: " + result.getDouble("total_payment"));

        }
        System.out.println();
    }

    public void showAcceptationInformationByDate() throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_ACCEPTOR_ACCEPTANCE = "select distinct acceptance_date, sum(net_weight) as total_weight, " +
                "sum(total_payment) as total_payment from acceptanceScrap group by acceptance_date";
        ResultSet result = statement.executeQuery(SQL_SHOW_ACCEPTOR_ACCEPTANCE);
        while (result.next()) {
            String formattedDouble = new DecimalFormat("#0.00").format(result.getDouble("total_payment") / result.getDouble("total_weight"));
            System.out.println(result.getString("acceptance_date") + " общий вес: " + result.getDouble("total_weight") + " по средней цене: " +
                    formattedDouble + " на сумму: " + result.getDouble("total_payment"));

        }
        System.out.println();
    }
}

