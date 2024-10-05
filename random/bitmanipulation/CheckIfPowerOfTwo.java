package random.bitmanipulation;

public class CheckIfPowerOfTwo {

    public static boolean isPowerOf2(int n){
        //There must be one set bit
        //Every power of 2 has one set bit in it

        //by turning off the rightmost bit which is the only set bit in a power of 2
        return (n & n-1) ==0;

    }

    public static void main(String[] args) {
        System.out.println(isPowerOf2(14));
    }
}
