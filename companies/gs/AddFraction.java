package companies.gs;

public class AddFraction {

    /**
     * Given two fractions passed in as int arrays,
     * returns the fraction which is result of adding the two input fractions.
     */

    public static int[] addFractions(int[] fraction1, int[] fraction2) {
        // Extract numerator and denominator from the input arrays

        int num1 = fraction1[0];
        int den1 = fraction1[1];
        int num2 = fraction2[0];
        int den2 = fraction2[1];

        if(den1== 0 || den2 ==0){
            throw new IllegalArgumentException("Denominator cannot be zero");
        }

        int newDen = den1 * den2;
        int newNum = num1 * den2 + num2 * den1;

        int gcd = calcGCD(newNum, newDen);

        return new int[]{newNum/gcd, newDen/gcd};

    }

    private static int calcGCD(int a, int b) {

        a = Math.abs(a);
        b = Math.abs(b);

        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }

        return a;
    }

    public static void main(String[] args) {
        int[] fraction1 = {1, 2};
        int[] fraction2 = {1, 3};

        int[] result = addFractions(fraction1, fraction2);

        System.out.println(result[0] + "/" + result[1]);
    }

}
