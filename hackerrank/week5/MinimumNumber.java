package hackerrank.week5;

public class MinimumNumber {
    /*
    Louise joined a social networking site to stay in touch with her friends. The signup page required her to input a name and a password.
    However, the password must be strong. The website considers a password to be strong if it satisfies the following criteria:

    Its length is at least .
    It contains at least one digit.
    It contains at least one lowercase English character.
    It contains at least one uppercase English character.
    It contains at least one special character. The special characters are: !@#$%^&*()-+
    She typed a random string of length  in the password field but wasn't sure if it was strong.
    Given the string she typed, can you find the minimum number of characters she must add to make her password strong?
     */

    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong

        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";

        if (n==0){
            return 6;
        }

        int numLength = 0;
        int lowerLength = 0;
        int upperLength = 0;
        int specialLength = 0;
        int totalLength = 0;

        for (char c : password.toCharArray()){
            totalLength++;

            if (numbers.indexOf(c)!=-1){
                numLength++;
            }else if(lower_case.indexOf(c)!=-1){
                lowerLength++;
            }else if(upper_case.indexOf(c)!=-1){
                upperLength++;
            }else if(special_characters.indexOf(c)!=-1){
                specialLength++;
            }
        }

        int minNumber = 0;

        if (numLength == 0) {
            minNumber++;
        }
        if (specialLength == 0) {
            minNumber++;
        }
        if (upperLength == 0) {
            minNumber++;
        }
        if (lowerLength == 0) {
            minNumber++;
        }

        if (minNumber==0 && totalLength <6){
            return 6-totalLength;
        }


        return minNumber;
    }



    public static int minimumNumber2(int n, String password) {
        // Return the minimum number of characters to make the password strong

        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";

        boolean hasDigit = false;
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (numbers.indexOf(c) != -1) hasDigit = true;
            else if (lower_case.indexOf(c) != -1) hasLower = true;
            else if (upper_case.indexOf(c) != -1) hasUpper = true;
            else if (special_characters.indexOf(c) != -1) hasSpecial = true;
        }

        int missingTypes = 0;
        if (!hasDigit) missingTypes++;
        if (!hasLower) missingTypes++;
        if (!hasUpper) missingTypes++;
        if (!hasSpecial) missingTypes++;


        return Math.max(missingTypes, 6 - n);
    }


    public static void main(String[] args) {
        System.out.println(minimumNumber2(3, "Ab1"));
    }
}
