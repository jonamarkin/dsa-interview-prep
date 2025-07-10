package companies.gs;

public class PangramDetector {

    public static String findMissingLetters(String sentence){
        String ALPHABETS = "abcdefghijklmnopqrstuvwxyz";

        sentence = sentence.toLowerCase();

        for(int i=0; i<sentence.length(); i++){
            int index = ALPHABETS.indexOf(sentence.charAt(i));

            if(index != -1){
                ALPHABETS = ALPHABETS.substring(0, index) + ALPHABETS.substring(index+1);
            }
        }

        return ALPHABETS;
    }

    public static void main(String[] args) {
        boolean success = true;

        success = success && "".equals(findMissingLetters("The quick brown fox jumps over the lazy dog"));
        success = success && "abcdefghijklmnopqrstuvwxyz".equals(findMissingLetters(""));
        success = success && "dg".equals(findMissingLetters("The quick brown fox jumps over the lazy"));
        if (success) {
            System.out.println("Pass ");
        } else {
            System.out.println("Failed");
        }
    }
}
