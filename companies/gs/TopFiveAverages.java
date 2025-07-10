package companies.gs;

import java.util.*;

public class TopFiveAverages {

    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        //Step 1: Build min-heaps of top 5 scores per student
        for(int[] item : items){
            int studentId = item[0];
            int score = item[1];

            map.putIfAbsent(studentId, new PriorityQueue<>());
            PriorityQueue<Integer> scores = map.get(studentId);
            scores.offer(score);

            if(scores.size() > 5){
                scores.poll();
            }
        }

        List<int[]> result = new ArrayList<>();

        for(Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()){
            int studentId = entry.getKey();
            PriorityQueue<Integer> scores = entry.getValue();

            int sum = 0;
            while(!scores.isEmpty()){
                sum += scores.poll();
            }

            int average = sum/5;
            result.add(new int[]{studentId, average});
        }

        //sort by student id in increasing order
        Collections.sort(result, (a,b) -> Integer.compare(a[0], b[0]));
        return result.toArray(new int[result.size()][]);
    }


    public static void main(String[] args) {
        int[][] items = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        TopFiveAverages topFiveAverages = new TopFiveAverages();
        int[][] result = topFiveAverages.highFive(items);
        for(int[] item : result){
            System.out.println(Arrays.toString(item));
        }
    }
}
