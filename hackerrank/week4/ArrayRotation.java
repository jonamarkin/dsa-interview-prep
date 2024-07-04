package hackerrank.week4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayRotation {

    /*
    A left rotation operation on an array of size n  shifts each of the array's elements 1 unit to the left.
    Given an integer, d , rotate the array that many steps left and return the result.
     */
    public static void main(String[] args) {
        List<Integer> list = Stream.of(1,2,3,4,5).collect(Collectors.toList());
        int d = 2;

        System.out.println(rotateLeft(2, list));
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        int n = arr.size();
        List<Integer> rotatedArray = new ArrayList<>();

        //Normalize d to prevent unnecessary rotations - In case d is greater than the length of the array
        d=d%n;

        //Append from d to the end of the array to the rotatedArray list
        for(int i = d; i<n; i++){
            rotatedArray.add(arr.get(i));
        }

        //Now append from the beginning of the arr to do to the rotatedArray list
        for(int i = 0; i <d; i++){
            rotatedArray.add(arr.get(i));
        }

        return rotatedArray;

    }
}
