package hackerrank.week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BetweenTwoSets {

    public static void main(String[] args) {
        List<Integer> firstArray = Stream.of(2,6).collect(Collectors.toList());
        List<Integer> secondArray  = Stream.of(24, 36).collect(Collectors.toList());

        System.out.println(getTotalX(firstArray, secondArray));
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Sort the two lists
        Collections.sort(a);
        Collections.sort(b);

        int beginBetween = a.getLast();
        int endBetween = b.getFirst();

        int count = 0;
        boolean firstArrayCheck = true;
        boolean secondArrayCheck = true;

        for(int i = beginBetween; i<=endBetween; i++){

            firstArrayCheck = true;
            for(int aint: a){
                if (i%aint !=0 ){
                    firstArrayCheck = false;
                    break;
                }

            }

            if(firstArrayCheck){
                secondArrayCheck = true;
                for(int bint: b){
                    if(bint%i !=0){
                        secondArrayCheck = false;
                        break;
                    }
                }

                if(secondArrayCheck){
                    count ++;
                }
            }
        }
        return count;
    }
}
