package faang.amazon;

import java.util.PriorityQueue;

public class MinCostToConnectSticks {

    public int connectSticks(int[] sticks) {


        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int stick: sticks){
            minHeap.offer(stick);
        }

        int totalCost = 0;

        while (minHeap.size() > 1){
            int stick1 = minHeap.poll();
            int stick2 = minHeap.poll();

            int combinedCost = stick1 + stick2;
            totalCost+=combinedCost;

            minHeap.offer(combinedCost);
        }

        return totalCost;
    }


    /*
    Time is O(nlogn)
    We insert all the n sticks into the heap and each insertion in the heap takes logn
    Space is O(n)
     */
}
