package blind75.arraysandstrings;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {

    /*
    There are n kids with candies. You are given an integer array candies, where each candies[i] represents
    the number of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.

    Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies,
    they will have the greatest number of candies among all the kids, or false otherwise.

    Note that multiple kids can have the greatest number of candies.
     */

    public static void main(String[] args) {

        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;

        System.out.println(kidsWithCandies(candies, extraCandies));
    }


    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int greatest = Integer.MIN_VALUE;

        for (int val: candies){
            if (val>greatest){
                greatest = val;
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int val: candies){
            if (val+extraCandies>=greatest){
                result.add(true);
            }else{
                result.add(false);
            }
        }

        return result;
    }
}
