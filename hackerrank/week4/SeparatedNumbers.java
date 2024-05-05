package hackerrank.week4;

public class SeparatedNumbers {

    public static void main(String[] args) {

    }

    public static void separateNumbers(String s) {
        // Write your code here

        char[] charArray = s.toCharArray();
        String response = "YES "  + charArray[0];
        for(int i =1; i <charArray.length; i++){
            if(!(charArray[i] - charArray[i-1]==1)){
                response = "NO";
                break;

            }
        }

        System.out.println(response);
    }
}
