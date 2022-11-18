import java.sql.*;
import java.util.Scanner;

public class LoginAndPasswordVerification {
    ConnectionToDB connectionToDB = new ConnectionToDB();
    Connection connection = connectionToDB.connection;
    Scanner scanner = new Scanner(System.in);
    private static String loginToCheck = null;
    private static String passwordToCheck = null;
    private static final String SQL_LOGIN_VERIFICATION = "select user_name from \"user_list\" order by id";
    private static final String SQL_ACCESS_VERIFICATION = "select access_type from \"user_list\" where user_name = ?";
    private static final String SQL_PASSWORD_VERIFICATION = "select user_password from \"user_list\" where user_name = ?";
    boolean accessLoginVerificationFlag = false;
    boolean accessPasswordVerificationFlag = false;
    int accessType = 0;

    public String getLogin() {
        System.out.println("Введите логин: ");
        loginToCheck = scanner.nextLine();
        return loginToCheck;
    }

    public String getPassword() {
        System.out.println("Введите пароль: ");
        passwordToCheck = scanner.nextLine();
        return passwordToCheck;
    }

    public void loginVerification() throws SQLException {
        getLogin();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(SQL_LOGIN_VERIFICATION);
        while (result.next()) {
            if (result.getString("user_name").equals(loginToCheck)) {
                accessLoginVerificationFlag = true;
                break;
            }
        }
        if (!accessLoginVerificationFlag){
            System.out.print("Некорректный логин. ");
        }


    }

    public void passwordVerification() throws SQLException {
        getPassword();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_PASSWORD_VERIFICATION);
        preparedStatement.setString(1, loginToCheck);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            if (result.getString("user_password").equals(passwordToCheck)) {
                accessPasswordVerificationFlag = true;
                break;
            }
        }
        if (!accessPasswordVerificationFlag){
            System.out.print("Некорректный пароль. ");
        }
    }

    public void getAccessType() throws SQLException {

        if (accessLoginVerificationFlag) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ACCESS_VERIFICATION);
            preparedStatement.setString(1, loginToCheck);
            ResultSet result1 = preparedStatement.executeQuery();
            while (result1.next()) {
                accessType = result1.getInt("access_type");
            }
        }
    }


}





    

  