import java.sql.*;
import java.util.Scanner;

public class Main {

    public String getLogin() {
        System.out.println("Введите логин");
        Scanner login = new Scanner(System.in);
        return login.nextLine();
    }

    public String getPassword() {
        System.out.println("Введите пароль");
        Scanner password = new Scanner(System.in);
        return password.nextLine();
    }


    public static void main(String[] args) throws SQLException {
        Main start = new Main();
        start.getLogin();
        start.getPassword();
        AdminAccess adminAccess = new AdminAccess();
        do {
            adminAccess.controller();
        } while (adminAccess.endFlag);
        }
    }




