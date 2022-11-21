import java.sql.*;
import java.util.Scanner;

public class OperationWithUserList {
    Scanner scanner = new Scanner(System.in);
    ConnectionToDB connectionToDB = new ConnectionToDB();
    Connection connection = connectionToDB.connection;

    public void addUser() throws SQLException {
        String sql = "insert into user_list (user_name, user_password, access_type) values (?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("Введите имя нового пользователя: ");
        scanner.nextLine();
        String userName = scanner.nextLine();
        preparedStatement.setString(1, userName);
        System.out.println("Введите пароль нового пользователя: ");
        String userPassword = scanner.nextLine();
        preparedStatement.setString(2, userPassword);
        System.out.println("Введите тип доступа: ");
        int accessType = scanner.nextInt();
        preparedStatement.setDouble(3, accessType);
        preparedStatement.executeUpdate();
    }

    public void showUserInformation() throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_ACCEPTANCE = "select * from user_list order by id";
        ResultSet result = statement.executeQuery(SQL_SHOW_ACCEPTANCE);
        while (result.next()) {
            System.out.println(result.getInt("id") + " " +result.getString("user_name") + " " +
                    result.getString("user_password") + " " + result.getString("access_type"));
        }
        System.out.println();
    }
    public void changeUserInformation() throws SQLException {
        String SQL = "update user_list set user_name = ?, user_password = ?," +
                "access_type = ? where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        System.out.println("Введите ID изменяемого пользователя: ");
        int id = scanner.nextInt();
        preparedStatement.setInt(4, id);
        System.out.println("Введите новое имя: ");
        scanner.nextLine();
        String userName = scanner.nextLine();
        preparedStatement.setString(1, userName);
        System.out.println("Введите новый пароль: ");
        String userPassword = scanner.nextLine();
        preparedStatement.setString(2, userPassword);
        System.out.println("Введите тип доступа: ");
        int accessType = scanner.nextInt();
        preparedStatement.setInt(3, accessType);
        preparedStatement.executeUpdate();
    }
    public void deleteUser() throws SQLException {
        String SQL = "delete from user_list where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        System.out.println("Введите ID пользователя для удаления: ");
        int id = scanner.nextInt();
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
