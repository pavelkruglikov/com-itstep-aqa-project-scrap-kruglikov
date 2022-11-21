import java.sql.*;

public class Main {
    private static int countOfLoginInput = 5;
    private static int countOfPasswordInput = 5;
    public static void main(String[] args) throws SQLException {
        LoginAndPasswordVerification verification = new LoginAndPasswordVerification();

        do {
            verification.loginVerification();
            if (!verification.accessLoginVerificationFlag) {
                System.out.println("Осталось попыток " + (countOfLoginInput - 1));
            }
            countOfLoginInput--;
        }
        while (!verification.accessLoginVerificationFlag & countOfLoginInput > 0);
        if (countOfLoginInput == 0) {
            System.out.println("Программа закрыта");
            System.exit(0);
        }


        do {
            verification.passwordVerification();
            if (!verification.accessPasswordVerificationFlag) {
                System.out.println("Осталось попыток " + (countOfPasswordInput - 1));
            }
            countOfPasswordInput--;

        }
        while (!verification.accessPasswordVerificationFlag & countOfPasswordInput > 0);
        if (countOfPasswordInput == 0) {
            System.out.println("Программа закрыта");
            System.exit(0);
        }

        verification.getAccessType();

        switch (verification.accessType) {
            case 1 -> {
                System.out.println("Выполнен вход как администратор");
                System.out.println();
                AdminMenu adminMenu = new AdminMenu();
                do {
                    adminMenu.controller();
                } while (adminMenu.endFlag);

            }
            case 2 -> {
                System.out.println("Выполнен вход как приемщик");
                System.out.println();
                AcceptorMenu acceptorMenu = new AcceptorMenu();
                do {
                    acceptorMenu.controller();
                } while (acceptorMenu.endFlag);
            }
        }


    }
}




