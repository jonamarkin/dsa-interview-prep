package companies.gs;

public class RunLength {

    public static String encode(String input){

        if(input ==null || input.isEmpty()){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int count = 1;
        char prevChar = input.charAt(0);

        for(int i=1; i<input.length(); i++){
            char currentChar = input.charAt(i);

            if(currentChar == prevChar){
                count++;
            }else{
                sb.append(count).append(prevChar);
                count = 1;
                prevChar = currentChar;
            }
        }

        sb.append(count).append(prevChar);

        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "aaaabbbbccccdddd";
        System.out.println(encode(input));
    }
}
