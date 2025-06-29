package hackerrank.week5;

import java.math.BigInteger;

public class FibonacciModified {

    public static BigInteger fibonacciModified(int t1, int t2, int n) {
        // Write your code here

        BigInteger term1 = BigInteger.valueOf(t1);
        BigInteger term2 = BigInteger.valueOf(t2);

        if (n==1) {
            return term1;
        }

        if(n==2){
            return term2;
        }

        BigInteger nextTerm = BigInteger.ZERO;

        for(int i=3; i<=n; i++){
            nextTerm = term1.add(term2.multiply(term2));

            term1 = term2;
            term2 = nextTerm;
        }


        return term2;

    }
}
