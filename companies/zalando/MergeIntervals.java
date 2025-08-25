package companies.zalando;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    /*
    Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
    and return an array of the non-overlapping intervals that cover all the intervals in the input.
     */

    public static int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return new int[0][];

        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();

        list.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] > list.getLast()[1]){
                list.add(intervals[i]);
            }else{
                list.getLast()[1]  = Math.max(intervals[i][1], list.getLast()[1]);
            }
        }

        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1,2},
                {2, 5},
                {6, 10},
                {11, 20},
                {21,25},
                {25,30}
        };

        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}
