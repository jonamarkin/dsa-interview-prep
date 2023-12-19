package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class DivisibleSumPairs {

    public static void main(String[] args) {
        List<Integer> arr = List.of(1, 2, 3, 4, 5, 6);
        int k = 5;
        int n = arr.size();

        System.out.println(divisibleSumPairs(n, k, arr));
    }

    /*
     * Complete the 'divisibleSumPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER n
     * 2. INTEGER k
     * 3. INTEGER_ARRAY ar
     */

    // First slow solution
    public static int divisibleSumPairs(int n, int k, List<Integer> arr) {

        List<List<Integer>> solutionSet = new ArrayList<>();

        // Use two loops
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if ((arr.get(j) + arr.get(i)) % k == 0) {
                    solutionSet.add(List.of(arr.get(i), arr.get(j)));
                }
            }
        }
        System.out.println(solutionSet);
        return solutionSet.size();
    }

}