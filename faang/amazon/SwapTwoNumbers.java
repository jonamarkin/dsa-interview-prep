package faang.amazon;

public class SwapTwoNumbers {
    /*
    Swp two numbers without a third variable


    XOR of same numbers is 0

     */

    public static int swapNumbers(int a, int b){
        //Use the XOR operator
        a = a ^b;
        b = a ^ b;
        a = a^b;

        return a;
    }

    public static void main(String[] args) {
        System.out.println(swapNumbers(5,6));
    }


}
