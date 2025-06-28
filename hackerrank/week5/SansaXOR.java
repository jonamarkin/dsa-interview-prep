package hackerrank.week5;

import java.util.List;

public class SansaXOR {

    public static int sansaXor(List<Integer> arr) {
        // Write your code here

        int n = arr.size();

        // Case 1: If the length of the array 'n' is even.
        // In this scenario, every element arr[i] will be part of an even
        // number of contiguous subarrays. When an element is XORed an even
        // number of times, its contribution cancels out (e.g., x ^ x = 0).
        // Therefore, the final result will be 0.
        if(n%2 ==0){
            return 0;
        }


        // Case 2: If the length of the array 'n' is odd.
        // In this scenario, only elements at even indices (0, 2, 4, ...)
        // will be part of an odd number of contiguous subarrays.
        // Elements at odd indices will be part of an even number of subarrays.
        // So, we only need to XOR the elements located at even indices.
        int result= 0;

        for(int i=0; i<n; i+=2){
            result ^= arr.get(i);
        }

        return result;

    }
}
