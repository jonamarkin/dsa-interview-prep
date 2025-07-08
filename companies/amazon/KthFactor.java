package companies.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthFactor {

    /*
    You are given two positive integers n and k. A factor of an integer n is defined as an integer i where n % i == 0.

    Consider a list of all factors of n sorted in ascending order, return the kth factor in this list or
    return -1 if n has less than k factors.
     */

    public int kthFactor(int n, int k) {

        List<Integer> factors = new ArrayList<>();

        for (int i=1; i<=Math.sqrt(n); i++){
            if (n%i==0){
                factors.add(i);

                if (i!=n/i){
                    factors.add(n/i);
                }
            }
        }

        Collections.sort(factors);

        if (k<=factors.size()){
            return factors.get(k-1);
        }else{
            return -1;
        }
    }
}
