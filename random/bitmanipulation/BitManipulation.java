package random.bitmanipulation;

public class BitManipulation {

    public static void main(String[] args) {
        int x = 12;
        int y = 10;

        //Bitwise AND
        System.out.println("Bitwise AND of (" + x + " , " + y + ") is: " + (x & y));

        //Bitwise OR
        System.out.println("Bitwise OR of " + x + ", " + y + " is: " + helperOR(x, y));

        int a = 1;
        System.out.println("Bitwise NOT of a is : " + ~a);

        System.out.println("Bitwise XOR of (x , y) is : " + (x ^ y));

        int number = 100;
        System.out.println(number + " shifted 1 position left, yields to " + helperShift(number, 1));
        System.out.println(number + " shifted 2 positions left, yields to " + helperShift(number, 2));
        System.out.println(number + " shifted 3 positions left, yields to " + helperShift(number, 3));
        System.out.println(number + " shifted 4 positions left, yields to " + helperShift(number, 4));
    }

    private static int helperOR(int x, int y) {
        return x | y;
    }

    private static int helperShift(int number, int i) {
        return number << i;// multiplies `number` with 2^i times.
    }


}
