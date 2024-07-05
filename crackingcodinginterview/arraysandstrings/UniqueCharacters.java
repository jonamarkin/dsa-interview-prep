package crackingcodinginterview.arraysandstrings;

public class UniqueCharacters {
    public static void main(String[] args) {
        System.out.println(allUnique("abcdd"));
    }

    /*
    Implement an algorithm to determine if a string has all unique characters. What if you can not use additional data structures?
     */

    public static boolean allUnique(String str){
        boolean[] chars = new boolean[256];

        for (int i=0; i<str.length(); i++){
            int charInt =  str.charAt(i);

            if(chars[charInt]){
                return false;
            }

            chars[charInt] = true;
        }

        return true;
    }

    /*
    Other methods
    - Use two loops with will give On^2
    - Sort and then scan fro left to right Onlogn

     */

}
