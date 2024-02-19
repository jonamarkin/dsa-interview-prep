package hackerrank.week3;

import java.util.Scanner;

public class StringsXOR {

    /*
    With two inputs, XOR is true if and only if the inputs differ (one is true, one is false).
    With multiple inputs, XOR is true if and only if the number of true inputs is odd.
     */

    /*
    Question was about a method to perform the XOR operation on two strings
    The two strings have the same length
     */

    public static String stringsXOR(String firstString, String secondString){
        StringBuilder stringBuilder = new StringBuilder();

        for (int i=0; i<firstString.length(); i++){
            if(firstString.charAt(i)==secondString.charAt(i)){
                stringBuilder.append("0");
            }else{
                stringBuilder.append("1");
            }
        }

        return stringBuilder.toString();
    }


    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first string");
        String firstString = scanner.nextLine();
        System.out.println("Enter the second string");
        String secondString = scanner.nextLine();

        System.out.println(stringsXOR(firstString, secondString));
    }
}
