package leetcode.blind75.binarysearch;

import java.util.Arrays;

public class SpellsAndPotions {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {


        Arrays.sort(potions);

        int n = spells.length;
        int[] result = new int[n];

        //For each spell count number of successful pairs
        for (int i=0; i<n; i++){
            result[i] = countSuccessfulPairs(spells[i], potions, success);
        }

        return result;
    }

    private int countSuccessfulPairs(int spell, int[] potions, long success) {
        int left = 0, right = potions.length;

        //Binary search
        while (left< right){
            int mid = left+(right-left)/2;
            //check if spell * potions[mid] >=success
            if ((long) spell * potions[mid]>=success){
                right=mid;
            }else{
                left = mid+1;
            }
        }

        return potions.length -left;
    }
}
