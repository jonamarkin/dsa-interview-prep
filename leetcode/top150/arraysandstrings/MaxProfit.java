package leetcode.top150.arraysandstrings;

public class MaxProfit {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int leftPointer = 0;
        int rightPointer =1;

        while(rightPointer < prices.length){

            int profit = prices[rightPointer] - prices[leftPointer];

            if(profit > 0){
                maxProfit  = Math.max(maxProfit, profit);
            }else{
                leftPointer = rightPointer;
            }


            rightPointer++;


        }

        return maxProfit;
    }
}
