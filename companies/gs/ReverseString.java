package companies.gs;

public class ReverseString {

    public static String reverse(String str){
        if(str == null || str.length() ==  1){
            return str;
        }

        return str.charAt(str.length()-1) + reverse(str.substring(0, str.length()-1));
    }

    public static String reverseIterative(String str){
        if(str == null || str.length() == 1){
            return str;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=str.length()-1; i>=0; i--){
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }

    public static String iterativeCharArray(String str){
        if(str == null || str.length() == 1){
            return str;
        }

        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length-1;

        while(left < right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(reverse(str));
    }
}
