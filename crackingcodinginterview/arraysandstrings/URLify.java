package crackingcodinginterview.arraysandstrings;

public class URLify {

    /*
    Write a method to replace all spaces in a string with '%20'. You may assume that the string
    has sufficient space at the end to hold the additional characters, and that you are given the "true"
    length of the string. (Note: If implementing in Java, please use a character array so that you can
    perform this operation in place.)
     */

    public static String urlify(String str, int trueLength){

        char[] charArray = str.toCharArray();
        int spaceCount = 0;

        for(int i=0; i<trueLength; i++){
            if(charArray[i]==' '){
                spaceCount++;
            }
        }

        int newLength = trueLength + spaceCount*2;

        for(int i = trueLength-1; i>=0; i--){
            if(charArray[i] == ' '){
                charArray[newLength-1] = '0';
                charArray[newLength-2] = '2';
                charArray[newLength-3] = '%';
                newLength = newLength-3;
            }else{
                charArray[newLength-1] = charArray[i];
                newLength = newLength-1;
            }
        }

        return new String(charArray);
    }

    public static String urlifyNoTrueLength(String str){

        char[] charArray = str.toCharArray();
        int spaceCount = 0;

        int trueLength = 0;
        //Loop from the end of the string to find the true length
        for(int i = charArray.length-1; i>=0; i--){
            if(charArray[i]!=' '){
                trueLength = i+1;
                break;
            }
        }

        for(int i=0; i<trueLength; i++){
            if(charArray[i]==' '){
                spaceCount++;
            }
        }



        int newLength = trueLength + spaceCount*2;

        for(int i = trueLength-1; i>=0; i--){
            if(charArray[i] == ' '){
                charArray[newLength-1] = '0';
                charArray[newLength-2] = '2';
                charArray[newLength-3] = '%';
                newLength = newLength-3;
            }else{
                charArray[newLength-1] = charArray[i];
                newLength = newLength-1;
            }
        }

        return new String(charArray);
    }

    public static void main(String[] args) {
        String str = "Mr John Smith    ";

        System.out.println(str.length());
        System.out.println(urlify(str, 13));
        System.out.println(urlifyNoTrueLength(str));
    }



}
