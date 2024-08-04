package leetcode.blind75.arraysandstrings;

import java.util.Arrays;

public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] arr2 = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf2(arr2)));
    }

    public static int[] productExceptSelf(int[] nums) {

        int len = nums.length;
        int[] result = new int[len];

        for (int i=0; i<len; i++){
            int product = 1;
            for (int j=0; j<len; j++){
                if (j==i){
                    continue;
                }else{
                    product*=nums[j];
                }
            }

            result[i] = product;
        }

        return result;
    }


    /*
    Be careful of zeros
    If there is one zero then all products will be zero except the one at the index of the zero
    If there are more than one zero then all products at each index will be zero

     */

    public static int[] productExceptSelf2(int[] nums) {

        int len = nums.length;
        int[] result = new int[len];

        int totalProduct = 1;
        int zeroIndex = -1;
        int zeroCount = 0;

        for (int i=0; i<len; i++){
            if (nums[i]==0){
                zeroIndex = i;
                zeroCount++;
            }else{
                totalProduct*=nums[i];
            }

        }

        if (zeroCount >1){
            return result;
        }


        if (zeroCount ==1){
            result[zeroIndex] = totalProduct;
            return result;
        }


        for (int i=0; i<len; i++){
            result[i] = totalProduct/nums[i];
        }

        return result;
    }
}
