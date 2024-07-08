package crackingcodinginterview.arraysandstrings;

import java.util.Arrays;

public class RemoveStringDuplicates {

    public static void main(String[] args) {

        char[] str = {'a', 'b', 'c', 'd', 'e', 'a', 'f', 'c', 'f', 'z'};
        System.out.println(removeDuplicates(str));
        System.out.println(removeDuplicatesWithBiffer(str));
    }

    // Implementation without additional buffer
    /*
    Use a double for loop
    Consider the first index as the first unique character
    Set the index for the next unique character to be the next, which is 1

    Start looping from the nextUnique index(1) to the end of the string
    At each index compare the value there to the part of the string considered to be containing the unique characters
    If a match is found there the loop breaks and goes to the next char.
    If a match is not found among the unique it is considered a unique and put in the position of the nextUnique
    nextUnique is then incremented
     */
    public static String removeDuplicates(char[] str){

        if (str ==null || str.length<2){
            return null;
        }

        int nextUnique = 1;

        for (int i = 1; i<str.length; i++){
            int j;
            for (j=0; j<nextUnique; j++){
                if (str[i]==str[j]){
                    break;
                }

            }

            if (j ==nextUnique){
                str[nextUnique] = str[i];
                nextUnique++;
            }

        }

        //str[nextUnique] = 0;
        //To set the rest to null
        for (int i = nextUnique; i < str.length; i++) {
            str[i] = '\0';
        }


        return Arrays.toString(str);
    }



    //Implementation with additional buffer
    /*
    Use a boolean array of size 256 to represent the 256 chars available

    Set all values to false
    Loop through the string
    Check if the value in the boolean array is true or not

     */

    public static String removeDuplicatesWithBiffer(char[] str){

        if (str ==null || str.length<2){
            return null;
        }

        int n = str.length;

        boolean[] seenChars = new boolean[256];
        for (int i = 0; i<n; i++){
            seenChars[i] = false;
        }

        int nextUnique = 0;

        for (int i = 0; i<n; i++){
            if (!seenChars[str[i]]){
                seenChars[str[i]] = true;
                str[nextUnique] = str[i];
                nextUnique++;
            }

        }

        //str[nextUnique] = 0;
        //To set the rest to null
        for (int i = nextUnique; i < n; i++) {
            str[i] = '\0';
        }


        return Arrays.toString(str);
    }


}
