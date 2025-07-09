package companies.gs;

public class LongestUniformsubstring {

    public static int[] longestUniformSubstring(String str) {
        if(str == null || str.isEmpty()){
            return new int[]{-1,0};
        }

        int maxLength = 1;
        int maxStart = 0;

        int currentLength = 1;
        int currentStart = 0;

        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) == str.charAt(i-1)){
                currentLength++;
            }else{
                currentLength = 1;
                currentStart = i;
            }

            if(currentLength > maxLength){
                maxLength = currentLength;
                maxStart = currentStart;
            }
        }

        return new int[]{maxStart, maxLength};
    }

    public static void main(String[] args) {
        String str = "aaaaaa";
        int[] result = longestUniformSubstring(str);
        System.out.println(result[0] + " " + result[1]);
    }
}
