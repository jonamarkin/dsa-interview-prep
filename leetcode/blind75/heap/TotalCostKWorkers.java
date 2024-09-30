package leetcode.blind75.heap;

import java.util.PriorityQueue;

public class TotalCostKWorkers {

    /*
    You are given a 0-indexed integer array costs where costs[i] is the cost of hiring the ith worker.

    You are also given two integers k and candidates. We want to hire exactly k workers according to the following rules:

    You will run k sessions and hire exactly one worker in each session.
    In each hiring session, choose the worker with the lowest cost from either the first candidates workers or the last candidates workers.
    Break the tie by the smallest index.
    For example, if costs = [3,2,7,7,1,2] and candidates = 2, then in the first hiring session,
    we will choose the 4th worker because they have the lowest cost [3,2,7,7,1,2].
    In the second hiring session, we will choose 1st worker because they have the same lowest cost as 4th worker but they
    have the smallest index [3,2,7,7,2]. Please note that the indexing may be changed in the process.
    If there are fewer than candidates workers remaining, choose the worker with the lowest cost among them.
    Break the tie by the smallest index.
    A worker can only be chosen once.
    Return the total cost to hire exactly k worker
     */
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        int left = 0;
        int right = costs.length-1;

        //Populate both heaps with up to 'candidates' workers from both sides
        for (int i=0; i<candidates && left <=right; i++){
            leftHeap.offer(costs[left++]);
        }

        for (int i=0; i<candidates && left <=right; i++){
            rightHeap.offer(costs[right--]);
        }

        long totalCost = 0;

        //Hire exactly k workers
        for (int i=0; i<k; i++){
            //Choose min cost from both heaps
            if (!leftHeap.isEmpty() && !rightHeap.isEmpty()){
                if (leftHeap.peek() <=rightHeap.peek()){
                    totalCost+=leftHeap.poll();
                    if (left<=right){
                        leftHeap.offer(costs[left++]);
                    }
                }else{
                    totalCost+=rightHeap.poll();
                    if (left<=right){
                        rightHeap.offer(costs[right--]);
                    }
                }
            } else if (!leftHeap.isEmpty()) {
                totalCost+=leftHeap.poll();
                if (left<=right){
                    leftHeap.offer(costs[left++]);
                }
            } else if (!rightHeap.isEmpty()) {
                totalCost+=rightHeap.poll();
                if (left<=right){
                    rightHeap.offer(costs[right--]);
                }
            }
        }
        return totalCost;
    }
}
