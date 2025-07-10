package companies.gs;

import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {

        //Handle zero numerator
        if (numerator ==0){
            return "0";
        }

        StringBuilder result = new StringBuilder();

        //Determine the sign
        if ((numerator<0) != (denominator<0)){
            result.append("-");
        }

        // Use long to avoid overflow when converting to positive absolute values
        long absNumerator = Math.abs((long) numerator);
        long absDenominator = Math.abs((long) denominator);

        // Append the integer part
        result.append(absNumerator / absDenominator);

        long remainder = absNumerator % absDenominator;

        //If remainder is 0, it's a terminating decimal
        if (remainder ==0){
            return result.toString();
        }

        // Append decimal point
        result.append(".");

        Map<Long, Integer> remainderMap = new HashMap<>();

        while (remainder !=0){
            if (remainderMap.containsKey(remainder)){
                result.insert(remainderMap.get(remainder), "(");
                result.append(")");
                return result.toString();
            }

            //Store the current reaminder and its position
            remainderMap.put(remainder, result.length());

            //Multiply remainder by 10 to get the next digit
            remainder *=10;
            result.append(remainder / absDenominator);

            remainder %= absDenominator;
        }

        return result.toString();
    }
}
