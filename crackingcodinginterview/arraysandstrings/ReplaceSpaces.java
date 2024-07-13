package crackingcodinginterview.arraysandstrings;

public class ReplaceSpaces {

    /*
    Write a method to replace all spaces in a string with ‘%20’.
     */

    public static void main(String[] args) {
        String input = "Mr John Smith    ";
        System.out.println(replaceSpaces(input));
    }

    /*
    Use String builder
    Create a new string  and append the charcaters in the old one to it, replacing the spaces with %20
     */

    public static String replaceSpaces(String str){

        StringBuilder stringBuilder = new StringBuilder();

        for(int i =0; i<str.length(); i++){
            if (str.charAt(i)==' '){
                stringBuilder.append("%20");
            }else{
                stringBuilder.append(str.charAt(i));
            }
        }

        return stringBuilder.toString();
    }
}
