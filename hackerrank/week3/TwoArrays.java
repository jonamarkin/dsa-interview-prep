package hackerrank.week3;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoArrays {

    public static void main(String[] args){
        List<Integer> listA = Stream.of(0,1).collect(Collectors.toList());
        List<Integer> listB = Stream.of(0,2).collect(Collectors.toList());
        int k = 1;

        /*
        You cannot use
        List<Integer> listA = Stream.of(0,1).toList(); to create your list because it will be immutable and you cannot carry out operations like Collections.sort
         */

        System.out.println(twoArrays(k, listA, listB));
    }

    /*
    A function that takes two arrays A and B and permutes them into A' and B' such that
    A'[i] + B'[i] >=k

    The logic

     To maximize the chances of satisfying the relation A[i]+B[j]≥kA[i]+B[j]≥k,
     we sort array A in ascending order and array B in descending order.
     This ensures that when we pair elements from A with elements from B, we maximize the sum.

     After sorting the arrays, we iterate through each element in A and corresponding element in B.
     If at any point A[i]+B[i]<kA[i]+B[i]<k, it means there's no permutation that satisfies the relation, so we return "NO".
     Otherwise, if we complete the iteration without encountering such a case, we return "YES".
     */
    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        // Write your code here

        //Sort the lists
        Collections.sort(A);
        Collections.sort(B);

        //Reverse the list B for it to be in descending order
        Collections.reverse(B);

        //Loop through both lists and compare the make the addition of the elements that occupy the same position to make sure they meet the requirement
        for(int i=0; i<A.size(); i++){
            if(A.get(i) + B.get(i) < k) return "NO";
        }
        return "YES";


    }
}
