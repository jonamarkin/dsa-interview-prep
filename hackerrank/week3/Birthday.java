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
        System.out.println(birthday2(chocolatebar, 4, 2));
    }


    /*
    First solution
    Uses two loops
    Time complexity of O(n.m)
     */
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


    /*
        Iterating through the Chocolate Bar:
        Imagine you have a chocolate bar with many squares, and you want to find different ways to break it into segments.
        Suppose you start eating the chocolate bar from the first square and you eat mm squares each time (because Ron's birth month is mm).
        After eating the first mm squares, you note down how much chocolate you've eaten (this is like calculating the sum).
        Now, instead of eating all the squares again from the beginning to calculate the sum for the next segment,
        you only need to add the next square of chocolate you're about to eat to the total you already know, and subtract the square you ate mm steps ago.
        This way, you can quickly know how much chocolate you've eaten for the current segment without doing all the calculations again from scratch.
        You keep doing this as you move along the chocolate bar, adding the next square and subtracting the square you ate mm steps ago.
        Each time, you check if the total amount of chocolate you've eaten equals Ron's birth day.
        By doing this, you find different ways to divide the chocolate bar into segments,
        and you count how many times the total chocolate you've eaten matches Ron's birth day.
        This count gives you the number of ways to divide the chocolate bar as Lily wants.

        Time complexity of o(n)
     */
    public static int birthday2(List<Integer> s, int d, int m) {
        // Write your code here
        int waysToDivide = 0;

        //Calculate the sum of the initial m squares
        int sum =0;
        for(int i=0; i<m; i++){
            sum += s.get(i);
        }

        if(sum ==d) waysToDivide++;

        //Now loop through s from position m
        for(int i=m; i<s.size(); i++){
            //Add next square to the sum
            sum +=s.get(i);
            //Remove the square that has gone out of scope  - The square you ate m steps ago
            sum-=s.get(i-m);

            if(sum ==d) waysToDivide++;
        }

        return waysToDivide;
    }


}
