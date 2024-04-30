package random;

import java.util.HashSet;
import java.util.Set;

public class DifferenceChecker {

    //check the existence of two elements with the absolute difference of k in an array
    public static boolean differenceChecker(int[] arr, int k){
        Set<Integer> integerSet = new HashSet<>();

        for(int num : arr){
            if(integerSet.contains(num + k) || integerSet.contains(num - k)){
                return true;
            }
            integerSet.add(num);
        }

        return false;
    }


    public static void main(String[] args) {
        int[] arr = {5,1,3,6,8};
        int k = 6;
        System.out.println(differenceChecker(arr, k));
    }

}
