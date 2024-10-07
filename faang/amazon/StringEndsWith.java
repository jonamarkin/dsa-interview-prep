package faang.amazon;

public class StringEndsWith {

    public static boolean solution(String str, String ending) {
        // Check if the `ending` length is greater than `str` length
        if (ending.length() > str.length()) {
            return false;
        }

        // Calculate the starting index for `str` from where to start comparing
        int startIndex = str.length() - ending.length();

        // Check each character of `ending` with the corresponding character in `str`
        for (int i = 0; i < ending.length(); i++) {
            if (str.charAt(startIndex + i) != ending.charAt(i)) {
                return false;
            }
        }

        return true;
    }


    public static boolean solutionSimple(String str, String ending) {
        return str.endsWith(ending);
    }
}
