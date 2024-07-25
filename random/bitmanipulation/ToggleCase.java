package random.bitmanipulation;

public class ToggleCase {

    public static void main(String[] args) {

        String str = "CheRrY";
        System.out.print("Toggle case: ");
        str = toggleCase(str);
        System.out.println(str);

        System.out.print("Original string: ");
        str = toggleCase(str);
        System.out.println(str);

    }


    //XORing any letter with 32 toggles its case

    public static String toggleCase(String s){
        char[] a = s.toCharArray();

        for (int i =0; i<a.length; i++){
            a[i]^=32;
        }

        return new String(a);
    }
}
