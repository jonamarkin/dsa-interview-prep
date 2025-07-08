package companies.gs;

public class AddFraction {

    /**
     * Given two fractions passed in as int arrays,
     * returns the fraction which is result of adding the two input fractions.
     */

    public static int[] addFractions(int[] fraction1, int[] fraction2) {
        // Extract numerator and denominator from the input arrays
        int numerator1 = fraction1[0];
        int denominator1 = fraction1[1];
        int numerator2 = fraction2[0];
        int denominator2 = fraction2[1];

        // Calculate the common denominator
        int commonDenominator = denominator1 * denominator2;

        // Calculate the new numerators
        int newNumerator1 = numerator1 * denominator2;
        int newNumerator2 = numerator2 * denominator1;

        // Add the numerators
        int resultNumerator = newNumerator1 + newNumerator2;

        // Return the result as an array
        return new int[]{resultNumerator, commonDenominator};

    }

}
