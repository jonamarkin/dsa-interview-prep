package hackerrank.week1;

import java.io.*;
import java.util.*;

/*
 * Problem Description
 * Camel Case is a naming style common in many programming languages. In Java, method and variable names typically start with a lowercase letter, with all subsequent words starting with a capital letter (example: startThread). Names of classes follow the same pattern, except that they start with a capital letter (example: BlueCar).

    Your task is to write a program that creates or splits Camel Case variable, method, and class names.

    Input Format

    Each line of the input file will begin with an operation (S or C) followed by a semi-colon followed by M, C, or V followed by a semi-colon followed by the words you'll need to operate on.
    The operation will either be S (split) or C (combine)
    M indicates method, C indicates class, and V indicates variable
    In the case of a split operation, the words will be a camel case method, class or variable name that you need to split into a space-delimited list of words starting with a lowercase letter.
    In the case of a combine operation, the words will be a space-delimited list of words starting with lowercase letters that you need to combine into the appropriate camel case String. Methods should end with an empty set of parentheses to differentiate them from variable names.
    Output Format

    For each input line, your program should print either the space-delimited list of words (in the case of a split operation) or the appropriate camel case string (in the case of a combine operation).
    Sample Input

    S;M;plasticCup()

    C;V;mobile phone

    C;C;coffee machine

    S;C;LargeSoftwareBook

    C;M;white sheet of paper

    S;V;pictureFrame

    Sample Output

    plastic cup

    mobilePhone

    CoffeeMachine

    large software book

    whiteSheetOfPaper()

    picture frame

    Explanation

    Use Scanner to read in all information as if it were coming from the keyboard.

    Print all information to the console using standard output (System.out.print() or System.out.println()).

    Outputs must be exact (exact spaces and casing).
 */

public class CamelCase {

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Split the input into various parts
            String[] splittedInput = line.split(";");
            String operation = splittedInput[0];
            String type = splittedInput[1];
            String words = splittedInput[2];

            // Check which operation is to be performed and act
            if (operation.equals("S")) {
                // We are supposed to split
                StringBuilder result = new StringBuilder();
                for (char ch : words.toCharArray()) {
                    if (Character.isUpperCase(ch)) {
                        result.append(' ').append(Character.toLowerCase(ch));
                    } else {
                        result.append(ch);
                    }
                }

                // If the type is a method we need to handle the ()
                if (type.equals("M") && result.toString().endsWith("()")) {
                    result.delete(result.length() - 2, result.length());
                }

                // Print out the result - trim to take care of extra spaces
                System.out.println(result.toString().trim());
            } else {
                StringBuilder result = new StringBuilder();
                boolean capitalizeNext = "C".equals(type); // Class names start with capitals
                for (String word : words.split(" ")) {
                    if (capitalizeNext) {
                        result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1));
                    } else {
                        result.append(word);
                    }

                    capitalizeNext = true;

                }

                // If a method add ()
                if (type.equals("M")) {
                    result.append("()");
                }

                System.out.println(result.toString());
            }

        }
    }

}
