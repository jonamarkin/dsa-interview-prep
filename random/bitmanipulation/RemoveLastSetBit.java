package random.bitmanipulation;

public class RemoveLastSetBit {
    /*
    Removing the rightmost set bit
     */

    public static int removeRightmost(int n){
        return n&n-1;
    }

    public static void main(String[] args) {
        System.out.println(removeRightmost(40));
    }
}
