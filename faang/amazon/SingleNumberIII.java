package faang.amazon;

import java.util.*;

public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : map.keySet()){
            if(map.get(num)==1){
                list.add(num);
            }

            if (list.size() >2){
                break;
            }
        }

        return new int[]{list.get(0), list.get(1)};
    }


    public int[] singleNumber2(int[] nums) {

        /*
        XOR all numbers:

        We start by XORing all numbers in the array.
        The result will be the XOR of the two unique numbers (let's call them x and y) because all other numbers appear
        twice and XOR with themselves to zero.

        Find the rightmost set bit:

        In the XOR result of x and y, any set bit indicates a position where x and y differ.
        We find the rightmost set bit, which will be used to separate x and y.

        Divide numbers into two groups and XOR:

        We iterate through the array again, dividing numbers into two groups based on whether they have the
        rightmost set bit or not.
        One group will contain x and all pairs that have this bit set.
        The other group will contain y and all pairs that don't have this bit set.
        XORing each group separately will give us x and y.

        This solution has a time complexity of O(n) as we iterate through the array twice.
        It uses only constant extra space O(1) as we only use a few integer variables regardless of the input size.
         */
        int xor =0;
        for (int num : nums){
            xor^=num;
        }

        int rightMostSetBit = 1;

        while ((xor & rightMostSetBit)==0){
            rightMostSetBit<<=1;
        }

        int x =0;
        int y =0;

        for (int num : nums){
            if ((num & rightMostSetBit) !=0){
                x^=num;
            }else{
                y^=num;
            }
        }

        return new int[]{x,y};
    }

}
