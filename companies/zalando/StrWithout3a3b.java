package companies.zalando;

public class StrWithout3a3b {

    public static String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();

        while(a>0 || b>0){

            int len = sb.length();
            boolean writeA;

            if(len>=2 && sb.charAt(len-1)==sb.charAt(len-2)){
                writeA = sb.charAt(len-1)=='b';
            }else{
                //Otherwise write the character with more remaining
                writeA = a>=b;
            }

            if(writeA && a>0){
                sb.append('a');
                a--;
            }else if(b>0){
                sb.append('b');
                b--;
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(strWithout3a3b(1, 2));
    }
}
