package hackerrank.week2;

public class MarsExploration {
    public static void main(String[] args) {

        System.out.println(marsExploration("SOSTOT"));
    }

    public static int marsExploration(String s) {
        // Write your code here
        // Define the repeating pattern we want to check our string against
        String sosPattern = "SOS";

        // We want to loop through the string s and make sure it consists of repeating
        // sequences of sosPattern
        // We will count the number of wrong letters or changed letters and return them
        // We can do a simple scan across the charArray of the string
        // Then we will use modulo to compare the various characters in the string and
        // the desired pattern
        // Using modulo will help us cycle through the pattern

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != sosPattern.charAt(i % 3)) {
                count++;
            }
        }

        return count;
    }
}
