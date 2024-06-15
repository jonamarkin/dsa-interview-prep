package hackerrank.week4;

public class CaesarCipher {
    public static void main(String[] args) {
        System.out.println(caesarCipher("abcdefghijklmnopqrstuvwxyz", 3));
    }

    /*
    Original alphabet:      abcdefghijklmnopqrstuvwxyz
    Alphabet rotated +3:    defghijklmnopqrstuvwxyzabc

    Note: The cipher only encrypts letters; symbols, such as -, remain unencrypted.
     */

    public static String caesarCipher(String s, int k) {
        // Write your code here
        char[] alphabets = alphabets();
        char[] stringChars = s.toCharArray();
        StringBuilder finalString = new StringBuilder();

        for (char stringChar : stringChars) {
            if (Character.isLetter(stringChar)) {
                //System.out.println("Yah " + stringChars[i]);
                for (int j = 0; j < alphabets.length; j++) {

                    if (alphabets[j] == stringChar) {

                        //System.out.println("Match " + stringChars[i]);
                        //stringChars[i] = alphabets[(j+k) % alphabets.length];
                        finalString.append(alphabets[(j + k) % alphabets.length]);
                    }
                }
            }
        }

        return finalString.toString();
    }


    public static char[] alphabets() {
        char[] alphabets = new char[26];

        for (int i = 0; i < 26; i++) {
            alphabets[i] = (char) ('a' + i);
        }

        return alphabets;
    }
}
