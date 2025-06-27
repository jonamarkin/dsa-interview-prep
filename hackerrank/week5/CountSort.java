package hackerrank.week5;

import java.util.ArrayList;
import java.util.List;

public class CountSort {
    public static void countSort(List<List<String>> arr) {
        // Write your code here

        int n = arr.size();
        int half = n/2;

        //Get the max
        int max = Integer.MIN_VALUE;

        for(List<String> pair: arr){
            int key = Integer.parseInt(pair.get(0));
            max = Math.max(key, max);
        }


        //Create array of lists up to the max
        List<List<String>> buckets  = new ArrayList<>();
        for(int i=0; i<=max; i++){
            buckets.add(new ArrayList<>());
        }


        //Fill the buckets
        for(int i=0; i<n; i++){
            int key = Integer.parseInt(arr.get(i).get(0));
            String value = (i <half) ? "-" : arr.get(i).get(1);
            buckets.get(key).add(value);
        }

        StringBuilder str = new StringBuilder();

        for(List<String> bucket: buckets){
            for(String s : bucket){
                str.append(s).append(" ");
            }
        }

        System.out.println(str.toString());




    }
}
