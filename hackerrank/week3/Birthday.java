package hackerrank.week3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    Question related to subarray division
 */
public class Birthday {

    public static void main(String[] args) {
        List<Integer> chocolatebar = Stream.of(2, 2, 1, 3, 2).collect(Collectors.toList());
        System.out.println(birthday(chocolatebar, 4, 2));
    }

    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here
        int waysToDivide = 0;

        //Loop through the list
        for (int i = 0; i < s.size(); i++) {
            //At each index move m steps and sum the integers to check if it equals d
            //If the sum equals d, increment the waysToDivide else do not increment

            //Check if i + m will be greater or equal to s.size()
            int sum = 0;
            if (!(i + m > s.size())) {
                for (int j = i; j <= i + m - 1; j++) {

                    sum += s.get(j);
                }
            }
            System.out.println("sum" + sum);
            if (sum == d) waysToDivide++;
        }
        return waysToDivide;

    }


}
