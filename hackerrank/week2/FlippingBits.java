package hackerrank.week2;

public class FlippingBits {

    public static void main(String[] args) {

        System.out.println(flippingBits(9));

    }

    public static long flippingBits(long n) {
        // Convert the integer into binary and left pad it with zeros to reach 32 bits

        String binaryString = Long.toBinaryString(n);
        String binaryString32Bits = String.format("%32s", binaryString).replaceAll(" ", "0");

        System.out.println(binaryString32Bits);

        StringBuilder flippedBits = new StringBuilder();

        for (Character ch : binaryString32Bits.toCharArray()) {
            if (ch.equals('0')) {
                flippedBits.append('1');
            } else if (ch.equals('1')) {
                flippedBits.append('0');
            }
        }

        System.out.println(flippedBits.toString());

        return Long.parseLong(flippedBits.toString(), 2);

    }
}