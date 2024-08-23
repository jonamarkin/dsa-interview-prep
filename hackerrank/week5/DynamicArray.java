package hackerrank.week5;

import java.util.ArrayList;
import java.util.List;

public class DynamicArray {

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // Write your code here
        int lastAnswer = 0;
        List<List<Integer>> arr = new ArrayList<>();

        for (int i=0; i<n; i++){
            arr.add(new ArrayList<>());
        }

        List<Integer> answers = new ArrayList<>();

        for (List<Integer> query: queries){

            int num = query.get(0);
            int x = query.get(1);
            int y = query.get(2);
            int idx = ((x ^ lastAnswer) %n);
            if (num==1){
                arr.get(idx).add(y);
            } else if (num==2) {
                lastAnswer = arr.get(idx).get(y % arr.get(idx).size());
                answers.add(lastAnswer);
            }
        }

        return answers;
    }

    public static void main(String[] args) {
        List<List<Integer>> values = new ArrayList<>();

        values.add(new ArrayList<>(List.of(1, 0, 5)));
        values.add(new ArrayList<>(List.of(1, 1, 7)));
        values.add(new ArrayList<>(List.of(1, 0, 3)));
        values.add(new ArrayList<>(List.of(2, 1, 0)));
        values.add(new ArrayList<>(List.of(2, 1, 1)));

        System.out.println(dynamicArray(2, values));
    }
}
