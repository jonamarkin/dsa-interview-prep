package companies.gs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountCycle {

    public static int countCycle(int[] arr, int startIndex) {
        int n = arr.length;

        if(startIndex < 0 || startIndex >= n){
            return -1;
        }

        int slow = startIndex;
        int fast = startIndex;

        do{
            slow = arr[slow];
            if (slow <0 || slow >= n){
                return -1;
            }

            if(fast < 0 || fast >= n){
                return -1;
            }
            fast = arr[fast];

            if(fast < 0 || fast >= n){
                return -1;
            }
            fast = arr[fast];

        }while (slow != fast);


        //Find the length of the cycle
        int cycleLength = 0;
        int current = slow;
        do {
            current = arr[current];
            cycleLength++;
            if (current < 0 || current >= n){
                return -1;
            }
        }while (current!=slow);


        return cycleLength;
    }

    public static int countCycle2(int[] arr, int startIndex) {
        int n = arr.length;
        if(startIndex < 0 || startIndex >= n){
            return -1;
        }

        boolean[] visited = new boolean[n];
        int current = startIndex;

        while(!visited[current]){
            visited[current] = true;

            if (arr[current] < 0 || arr[current] >= n){
                return -1;
            }

            current = arr[current];
        }

        int cycleStart = current;
        int cycleLength = 1;
        current =arr[current];

        while(current != cycleStart){
            if (current <0 || current >= n){
                return -1;
            }

            current = arr[current];
            cycleLength++;
        }

        return cycleLength;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,0,4,1};
        System.out.println(countCycle(arr, 0));
        System.out.println(countCycle2(arr, 0));
    }


}
