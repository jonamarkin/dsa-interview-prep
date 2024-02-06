package hackerrank.week2;

public class CountingValleys {

    public static void main(String[] args) {
        System.out.println(countingValleys(5, "DDUUUDDDUDUUUDDDUUU"));
    }

    public static int countingValleys(int steps, String path) {
        // Initialize a counter for the sea level and a counter for the valleyCount also
        // THe sea level will be incremented or decremented depending on what is
        // encountered in the path
        // If it's a U incremenet seaLevel by 1, if it's D, decrement seaLevel by -1
        // Valley start when seaLevel is -1 and ends when seaLevel gets back to 0
        // Whenever I encounter a U, I check if the current seaLevel is at -1. That
        // means it is about completing a valley

        int seaLevel = 0;
        int valleyCount = 0;

        for (Character p : path.toCharArray()) {
            if (p.equals('U')) {

                if (seaLevel == -1) {
                    valleyCount++;
                }
                seaLevel++;
            } else if (p.equals('D')) {
                seaLevel--;
            }
        }

        return valleyCount;
    }

}
