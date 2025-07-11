package companies.gs;

public class WordDistanceFinder {
    public static int findDistance(String sentence, String word1, String word2) {
        if(sentence == null || word1 == null || word2 == null){
             return -1;
         }

        String[] words = sentence.split("\\s+");
        int index1 = -1;
        int index2 = -1;
        int minDistance = Integer.MAX_VALUE;

        for(int i=0; i<words.length; i++){

            String word = words[i];

            if(word.equals(word1)){
                index1 = i;

            }else if(word.equals(word2)){
                index2 = i;
            }

            if(index1 != -1 && index2 != -1){
                minDistance = Math.min(minDistance, Math.abs(index1 - index2));
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    public static void main(String[] args) {
        String sentence = "This is a sentence";
        String word1 = "is";
        String word2 = "a";

        System.out.println("Distance between " + word1 + " and " + word2 + " in " + sentence + " is " + findDistance(sentence, word1, word2));
    }
}
