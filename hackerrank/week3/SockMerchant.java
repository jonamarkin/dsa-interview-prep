package hackerrank.week3;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class SockMerchant {

    /*
    TODO:
    There is a large pile of socks that must be paired by color.
    Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.
    Example:
    n=7
    array=[1,2,1,2,1,3,2]

    There is one pair of color 1 and one of color 2. There are three odd socks left, one of each color. The number of pairs is 2.

    Function Description

    Complete the sockMerchant function in the editor below.

    sockMerchant has the following parameter(s):

    int n: the number of socks in the pile
    int ar[n]: the colors of each sock
    Returns

    int: the number of pairs
     */
    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        //Make use of hashtable to the hold the socks and their counts
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int color: ar){
            hashMap.put(color, hashMap.getOrDefault(color, 0) +1);
        }

        int numberOfPairs =0;
        for(int val: hashMap.values()){
            if(val >=2){
                numberOfPairs += (val / 2);
            }
        }
        return numberOfPairs;
    }

    public static void main(String[] args) {
        List<Integer> list = Stream.of(1,2,1,2,1,3,2).toList();
        System.out.println(sockMerchant(7, list));
    }
}
