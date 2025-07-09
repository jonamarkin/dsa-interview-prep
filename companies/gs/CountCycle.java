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

    public static void main(String[] args) {
        int[] arr = {1,2,0,4,1};
        System.out.println(countCycle(arr, 0));
    }


}
