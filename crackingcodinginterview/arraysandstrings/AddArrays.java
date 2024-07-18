package crackingcodinginterview.arraysandstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AddArrays {

    /*
    You have two large integers represented as arrays
    Add them
     */

    public static void main(String[] args) {
        int[] firstArray = {9,2,3};
        int[] secondArray = {4,5,6};

        System.out.println(Arrays.toString(addTwoArrays(firstArray, secondArray)));
    }

    public static int[] addTwoArrays(int[] firstArray, int[] secondArray){

        ArrayList<Integer> resultList = new ArrayList<>();

        int maxLength = Math.max(firstArray.length, secondArray.length);

        int carry = 0;

        for (int i =0; i<maxLength; i++){
            int digit1 = i < firstArray.length ? firstArray[firstArray.length-1-i] : 0;
            int digit2 = i < secondArray.length ? secondArray[secondArray.length-1-i]:0;

            int sum = digit1 + digit2 + carry;
            int input = sum %10;
            carry = sum/10;

            resultList.add(input);
        }


        if (carry!=0){
            resultList.add(carry);
        }

        Collections.reverse(resultList);

        int[] resultArray = new int[resultList.size()];

        for (int i=0; i<resultList.size(); i++){
            resultArray[i] = resultList.get(i);
        }


        return resultArray;
    }
}
