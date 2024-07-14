package crackingcodinginterview.arraysandstrings;

public class ReplaceSpaces {

    /*
    Write a method to replace all spaces in a string with ‘%20’.
     */

    public static void main(String[] args) {
        String input = "Mr John Smith    ";
        System.out.println(replaceSpaces(input, 13));


        char[] input2 = "Mr John Smith    ".toCharArray();
        System.out.println(replaceSpacesInPlace(input2, 13));
    }

    /*
    Use String builder
    Create a new string  and append the charcaters in the old one to it, replacing the spaces with %20
     */

    public static String replaceSpaces(String str, int trueLength){

        StringBuilder stringBuilder = new StringBuilder();

        for(int i =0; i<trueLength; i++){
            if (str.charAt(i)==' '){
                stringBuilder.append("%20");
            }else{
                stringBuilder.append(str.charAt(i));
            }
        }

        return stringBuilder.toString();
    }


    /*
    Count the number of spaces in the original string
    Estimate the length of the new string with the addition of the characters to be put in the empty space
    We are to replace the empty space with three characters
    Hence since empty character already occupies 1 space, we are supposed to add 2 * the number of empty spaces. That will make up the new string length

    We can then loop in the char array from right to left
    At each index if it is a space, we put in the new charcters one index at a time
    Else we put the char there
     */
    public static char[] replaceSpacesInPlace(char[] str, int trueLength){

        int spaceCount = 0;
        for (int i=0; i<trueLength; i++){
            if (str[i]==' '){
                spaceCount++;
            }
        }

        int newLength = trueLength + spaceCount *2;
        int insertionIndex = newLength -1;

        for (int i = trueLength-1; i>=0; i--){
            if (str[i]==' '){
                str[insertionIndex] = '0';
                str[insertionIndex-1] = '2';
                str[insertionIndex - 2] = '%';
                insertionIndex-=3;
            }else{
                str[insertionIndex] = str[i];
                insertionIndex--;
            }
        }

        return str;
    }
}
