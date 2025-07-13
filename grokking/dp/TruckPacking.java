package grokking.dp;

public class TruckPacking {

    //Recursive solution
    public static int packRecursive(int[] weights, int i, int capacity) {
        if(weights.length == 0 || capacity == 0){
            return 0;
        }

        //If the current item does not fit do not take it
        if(weights[i] > capacity){
            return packRecursive(weights, i-1, capacity);
        }else{
            return Math.max(weights[i] + packRecursive(weights, i-1, capacity-weights[i]),
                    packRecursive(weights, i-1, capacity));
        }
    }
}
