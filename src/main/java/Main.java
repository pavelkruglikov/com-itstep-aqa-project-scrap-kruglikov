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
            case 1: {
                AdminAccess adminAccess = new AdminAccess();
                do {
                    adminAccess.controller();
                } while (adminAccess.endFlag);

            }
            case 2: {
                AcceptorAccess acceptorAccess = new AcceptorAccess();
                do{
                    acceptorAccess.controller();
                }while (acceptorAccess.endFlag);
            }
        }


    }
}


