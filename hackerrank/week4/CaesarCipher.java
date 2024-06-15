package hackerrank.week4;

public class CaesarCipher {
    public static void main(String[] args) {
        //System.out.println(caesarCipher("abcdefghijklmnopqrstuvwxyz", 3));
        System.out.println(caesarCipher("middle-Outz", 2));
        System.out.println(caesarCipherOpt("middle-Outz", 2));
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

                boolean isUpperCase = Character.isUpperCase(stringChar);
                //System.out.println("Yah " + stringChars[i]);
                for (int j = 0; j < alphabets.length; j++) {

                    if (Character.toLowerCase(alphabets[j]) == Character.toLowerCase(stringChar)) {

                        //System.out.println("Match " + stringChars[i]);
                        //stringChars[i] = alphabets[(j+k) % alphabets.length];
                        //finalString.append(alphabets[(j + k) % alphabets.length]);
                        finalString.append(isUpperCase?Character.toUpperCase(alphabets[(j + k) % alphabets.length]): alphabets[(j + k) % alphabets.length]);
                    }
                }
            }else{
                finalString.append(stringChar);
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





    public static String caesarCipherOpt(String s, int k) {
        StringBuilder finalString  = new StringBuilder();

        for (char c: s.toCharArray()){
            if (Character.isLetter(c)){
                char baseChar = Character.isUpperCase(c) ? 'A' : 'a';
                finalString.append((char) ( baseChar + (c-baseChar +k)%26));
            }else{
                finalString.append(c);
            }
        }

        return finalString.toString();
    }
}
