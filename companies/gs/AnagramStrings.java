package companies.gs;

public class AnagramStrings {

    //Check if two strings are anagrams without using any extra memory
    public static boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }

        if(s1.equals(s2)){
            return true;
        }

        char firstChar = s1.charAt(0);
        int index = s2.indexOf(firstChar);

        if(index == -1){
            return false;
        }

        return isAnagram(s1.substring(1), s2.substring(0, index) + s2.substring(index + 1));
    }

    public static void main(String[] args) {
        String s1 = "anagram";
        String s2 = "nagaram";

        System.out.println(isAnagram(s1, s2));
    }
}
