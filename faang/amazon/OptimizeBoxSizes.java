package faang.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OptimizeBoxSizes {

    public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
        // Write your code here

        Collections.sort(arr, Collections.reverseOrder());
        List<Integer> setA = new ArrayList<>();
        List<Integer> setB = new ArrayList<>(arr);


        // Collections.sort(arr);

        // setB.addAll(arr);

        long sumA = 0;
        long sumB = setB.stream().mapToLong(Integer::longValue).sum();

        for(int weight: arr){
            setA.add(weight);
            sumA+=weight;
            sumB-=weight;

            setB.remove((Integer) weight);

            if(sumA>sumB){
                break;
            }
        }

        Collections.reverse(setA);

        return setA;
    }
}
