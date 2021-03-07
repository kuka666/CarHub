package AirportManagement;

public class Checker {
    //checker password
    public boolean checkerPassoword(String password) {
        int a = 0, b = 0, c = 0, d = 0, e = 0;
        if (password.length() < 8) {
            System.out.println("Invalid password");
            return false;
        }

        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 65 && password.charAt(i) <= 90) {
                a++;
            }
            if (password.charAt(i) >= 97 && password.charAt(i) <= 122) {
                b++;
            }

            if (password.charAt(i) >= 48 && password.charAt(i) <= 57) {
                d++;
            }
            if (password.charAt(i) == '@' || password.charAt(i) == '/' || password.charAt(i) == '$' || password.charAt(i) == '!' || password.charAt(i) == '^') {
                e++;
            }
        }
        if (a > 0 && b > 0 && d > 0 && e > 0) {
            return true;
        } else {
            System.out.println("Invalid password");
            return false;
        }
    }

    public boolean checkage(String dateOfBirth) {
        if (dateOfBirth.length() < 10) {
            System.out.println("invalid date");
            return false;
        }
        if (dateOfBirth.charAt(6) >= 50 && dateOfBirth.charAt(9) > 51) {
            System.out.println("You can not buy a ticket due to your age!!!!!!");
            return false;

        }
        for (int i = 0; i < dateOfBirth.length(); i++) {
            if (dateOfBirth.charAt(i) < 48 && dateOfBirth.charAt(i) > 57) {
                System.out.println("invalid date");
                return false;
            }
        }
        if (dateOfBirth.charAt(2) != '-' && dateOfBirth.charAt(5) != '-') {
            System.out.println("invalid date");
            return false;
        }
        return true;
    }

    public boolean checkercardnumber(String number) {
        int a = 0;
        if (number.length() != 16) {
            System.out.println("Not enough number");
            return false;
        }

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) >= 48 && number.charAt(i) <= 57) {
                a++;
            }
        }
        if (a > 0 ) {
            return true;
        } else {
            System.out.println("Invalid number");
            return false;
        }
    }
    public boolean checkercarddate(String number) {
        int a = 0,b=0,c=0;
        if (number.length() != 5) {
            System.out.println("Not enough number");//12/23
            return false;
        }

        for (int i = 0; i < number.length(); i++) {
            if ((number.charAt(0) >= 48 && number.charAt(i) <= 57)&&(number.charAt(0) ==48 ||number.charAt(0) == 49)&&(number.charAt(3) ==50 &&(number.charAt(4) >= 48 && number.charAt(4) <= 57))) {
                a++;
            }
        }

        if (number.charAt(2) != '/') {
            System.out.println("invalid date");
            return false;
        }
        if (a > 0 ) {
            return true;
        } else {
            System.out.println("Invalid number");
            return false;
        }
    }
    public boolean checkCVV(String number) {
        if (number.length() != 3) {
            System.out.println("Not enough number");
            return false;
        }
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) <= 48 && number.charAt(i) >= 57) {
                return false;

            }
        }
        return true;

    }
}
