package leetcode.blind75.heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SmallestInfiniteSet {

    PriorityQueue<Integer> heap;
    Set<Integer> integerSet;
    int currentSmallest;

    public SmallestInfiniteSet() {
        heap = new PriorityQueue<>();
        integerSet = new HashSet<>();
        currentSmallest = 1;
    }

    public int popSmallest() {
        if (!heap.isEmpty()){
            int smallest = heap.poll();
            integerSet.remove(smallest);
            return smallest;
        }

        return currentSmallest++;
    }

    public void addBack(int num) {
        if (num < currentSmallest && !integerSet.contains(num)){
            heap.offer(num);
            integerSet.add(num);
        }
    }
}
