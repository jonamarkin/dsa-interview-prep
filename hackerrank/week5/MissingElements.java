package hackerrank.week5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MissingElements {

    /*
    Given two arrays of integers, find which elements in the second array are missing from the first array.
     */

    public static void main(String[] args) {

    }

    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        // Write your code here

        HashMap<Integer, Integer> arrHashMap = new HashMap<>();
        HashMap<Integer, Integer> brrHashMap = new HashMap<>();


        List<Integer> result = new ArrayList<>();

        for(int i:arr){
            arrHashMap.put(i, arrHashMap.getOrDefault(i, 0)+1);
        }

        for(int i:brr){
            brrHashMap.put(i, brrHashMap.getOrDefault(i, 0)+1);
        }

        //Compare
        for(Map.Entry<Integer, Integer> mapEntry: brrHashMap.entrySet()){

            int key = mapEntry.getKey();
            int value = mapEntry.getValue();

            if(arrHashMap.containsKey(key)){
                //Compare values
                if(value != arrHashMap.get(key)){
                    result.add(key);
                }
            }else{
                result.add(key);
            }

        }

        return result;
    }
}
