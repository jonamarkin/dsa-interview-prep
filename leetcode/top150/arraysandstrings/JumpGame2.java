package leetcode.top150.arraysandstrings;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame2 {

    /*
    You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

    Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

    0 <= j <= nums[i] and
    i + j < n
    Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
     */

    public static void main(String[] args) {

    }

    public int jump(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        int n = nums.length;

        int farthest = 0;
        int end = 0;
        int jumps = 0;


        for(int i=0; i<n; i++){
            farthest = Math.max(farthest, i+nums[i]);

            if(i == end){
                jumps++;
                end = farthest;

                if(end > n-1){
                    break;
                }
            }
        }

        return jumps;
    }


    //BFS Solution
    public int jump2(int[] nums) {

        int n = nums.length;
        if(n==1) return 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean visited[] = new boolean[n];
        visited[0] = true;
        int jumps = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            jumps++;

            for(int i=0; i<size; i++){
                int index = queue.poll();
                for(int j=i; j<=nums[index]; j++){
                    int next = index + j;
                    if(next>=n-1) return jumps;

                    if(!visited[next]){
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }
        }

        return -1;
    }

}
