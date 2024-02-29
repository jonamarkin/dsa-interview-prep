package hackerrank.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaximumPerimeterTriangle {

    /**
     * The Question
     * Given an array of stick lengths, use 3 of them to construct a non-degenerate triangle with the maximum possible perimeter.
     * Return an array of the lengths of its sides as 3 integers in non-decreasing order.
     *
     * If there are several valid triangles having the maximum perimeter:
     *
     * Choose the one with the longest maximum side.
     * If more than one has that maximum, choose from them the one with the longest minimum side.
     * If more than one has that maximum as well, print any one them.
     * If no non-degenerate triangle exists, return .
     */
    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {

        List<Integer> result = new ArrayList<>();

        boolean foundTraingle = false;
        int maxPerimeter = 0;
        //First sort the list of sticks so that we can easily identify the longest side that could potentially form a triangle
        Collections.sort(sticks);

        //By iterating over the sorted list from the right to the left we handle the conditions presented
        //We will always have the triangle with the longest minimum side and longest maximum side

        //Then iterate over the sorted error form the end to the beginning.
        //Start from the last but 2 element so that I can try and form a triangle with the preceding two sticks
        for(int i = sticks.size()-2; i>=0; i--){
            if(((sticks.get(i)+sticks.get(i+1))>sticks.get(i+2)) &&((sticks.get(i)+sticks.get(i+2))>sticks.get(i+1)) && (sticks.get(i+2)+sticks.get(i+1))>sticks.get(i)){
                //Meaning it can form a triangle
                int perimeter  = sticks.get(i) +sticks.get(i+1) + sticks.get(i+2);
                if(perimeter >= maxPerimeter){
                    maxPerimeter = perimeter;

                    result.clear();
                    result.add(sticks.get(i));
                    result.add(sticks.get(i+1));
                    result.add(sticks.get(i+2));
                    foundTraingle = true;
                }

            }
        }

        if(!foundTraingle){
            result.clear();
            result.add(-1);
        }
        return result;

    }


    //AI Generated Solution
    public static List<Integer> maximumPerimeterTriangle2(List<Integer> sticks) {
        sticks.sort((a, b) -> b - a);

        // Iterate through sticks to find the first valid triangle
        for (int i = 0; i < sticks.size() - 3; i++) {
            int side1 = sticks.get(i);
            int side2 = sticks.get(i + 1);
            int side3 = sticks.get(i + 2);

            // Check if the current three sides form a valid triangle
            if (side1 < side2 + side3 && side2 < side1 + side3 && side3 < side1 + side2) {
                // Return the sides in non-decreasing order
                return Arrays.asList(side3, side2, side1);
            }
        }

        // No valid triangle found, return -1
        return Arrays.asList(-1);
    }

    public static void main(String[] args) {
        List<Integer> arr = Stream.of(1,2,3,4,5,10).collect(Collectors.toList());

        System.out.println(maximumPerimeterTriangle(arr));
    }
}
