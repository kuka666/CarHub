package Airport;

public class Checker {    //class for checking the validity of input data

    public boolean checkerPassoword(String password) {   //password verification
        int a = 0, b = 0, c = 0, d = 0, e = 0;
        if (password.length() < 8) {   //the password must be at least 8 characters long
            System.out.println("Invalid password");
            return false;
        }

        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 65 && password.charAt(i) <= 90) {  //password must have one capital letter
                a++;
            }
            if (password.charAt(i) >= 97 && password.charAt(i) <= 122) { //password must have one lowercase letter
                b++;
            }

            if (password.charAt(i) >= 48 && password.charAt(i) <= 57) { //password must be one digit
                d++;
            }
            if (password.charAt(i) == '@' || password.charAt(i) == '/' || password.charAt(i) == '$' || password.charAt(i) == '!' || password.charAt(i) == '^') {  //the password must have one of these characters
                e++;
            }
        }
        if (a > 0 && b > 0 && d > 0 && e > 0) {  //if all variables are greater than 0, then the password was created correctly
            return true;
        } else {
            System.out.println("Invalid password");  //output if the password was not created correctly
            return false;
        }
    }

    public boolean checkage(String dateOfBirth) {  //age verification
        if (dateOfBirth.length() < 10) {  //format of the date dd-mm-yyyy, so it cannot contain more than 10 characters
            System.out.println("invalid date");
            return false;
        }
        if (dateOfBirth.charAt(6) >= 50 && dateOfBirth.charAt(9) > 51) { //as of this year 2021, everyone under 2003 is not an adult
            System.out.println("You can not buy a ticket due to your age!!!!!!");
            return false;

        }
        for (int i = 0; i < dateOfBirth.length(); i++) {
            if (dateOfBirth.charAt(i) < 48 && dateOfBirth.charAt(i) > 57) { //the date is written only in numbers
                System.out.println("invalid date");
                return false;
            }
        }
        if (dateOfBirth.charAt(2) != '-' && dateOfBirth.charAt(5) != '-') { //and the characters under the number 2 and 5 must be "-"
            System.out.println("invalid date");
            return false;
        }
        return true;
    }

    public boolean checkercardnumber(String number) {  //сard verification
        int a = 0;
        if (number.length() != 16) {  //card number can only have 16 characters
            System.out.println("Not enough number");
            return false;
        }

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) >= 48 && number.charAt(i) <= 57) { //card number can only have numbers
                a++;
            }
        }
        if (a > 0 ) {  //if variables а are greater than 0, then the card number was correct
            return true;
        } else {
            System.out.println("Invalid number");
            return false;
        }
    }
    public boolean checkercarddate(String number) {  //сard date verification
        int a = 0,b=0,c=0;
        if (number.length() != 5) {     //format of the card date mm/уу, so it cannot contain more than 5 characters
            System.out.println("Not enough number");
            return false;
        }

        for (int i = 0; i < number.length(); i++) {
            if ((number.charAt(0) >= 48 && number.charAt(i) <= 57)&&(number.charAt(0) ==48 ||number.charAt(0) == 49)&&(number.charAt(3) ==50 &&(number.charAt(4) >= 48 && number.charAt(4) <= 57))) {
                a++;   //a month cannot exceed 12, and the year must be some of the 3rd anniversary
            }
        }

        if (number.charAt(2) != '/') {  //the third character must be "/"
            System.out.println("invalid date");
            return false;
        }
        if (a > 0 ) {    //if variables а are greater than 0, then the card date was correct
            return true;
        } else {
            System.out.println("Invalid number");
            return false;
        }
    }
    public boolean checkCVV(String number) {  //сvv verification
        if (number.length() != 3) {   //сvv can only have 3 characters
            System.out.println("Not enough number");
            return false;
        }
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) <= 48 && number.charAt(i) >= 57) {  //сvv consists only of numbers
                return false;

            }
        }
        return true;

    }
}