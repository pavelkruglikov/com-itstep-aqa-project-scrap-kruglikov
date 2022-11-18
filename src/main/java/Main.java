import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        LoginAndPasswordVerification verification = new LoginAndPasswordVerification();
        do {
            verification.loginVerification();
        }
        while (!verification.accessLoginVerificationFlag);

        do {
            verification.passwordVerification();
        }
        while (!verification.accessPasswordVerificationFlag);

        verification.getAccessType();

        switch (verification.accessType) {
            case 1 -> {
                System.out.println("Выполнен вход как администратор");
                System.out.println();
                AdminAccess adminAccess = new AdminAccess();
                do {
                    adminAccess.controller();
                } while (adminAccess.endFlag);
                break;

            }
            case 2 -> {
                System.out.println("Выполнен вход как приемщик");
                System.out.println();
                AcceptorAccess acceptorAccess = new AcceptorAccess();
                do {
                    acceptorAccess.controller();
                } while (acceptorAccess.endFlag);
                break;
            }
        }


    }
}


