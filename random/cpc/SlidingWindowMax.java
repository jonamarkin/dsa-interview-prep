package random.cpc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

public class SlidingWindowMax {

    /*
    You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
    You can only see the k numbers in the window. Each time the sliding window moves right by one position.
     */

    public static void main(String[] args) {

        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindowBST(arr, 3)));
    }

    //Trivial Solution
    public static int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        if (k > n) {
            return new int[0];
        }

        int[] maxArray = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {

                max = Math.max(max, nums[j]);

            }
            maxArray[i] = max;
        }

        return maxArray;
    }

    //Heap Solution

    /*
    Explanation:
    TreeSet for BTreeSet:
    Java's TreeSet maintains elements in sorted order, similar to Rust's BTreeSet. Each element is a pair (value, index) encapsulated in the Element class.

    Element Class:
    Implements Comparable to define a custom sorting order: sort by value first, then by index.
    Overrides equals and hashCode to ensure correct behavior when removing elements from the set.

    Max Tracking:
    The maximum value so far (maxSoFar) is tracked manually to avoid frequent calls to set.last(), which retrieves the largest element in TreeSet.
    When an element is removed, we check if it was the maximum. If it was, we update maxSoFar by querying set.last().
    Output Array: The results are stored in an integer array (maxs), sized to hold all sliding window maximums.
     */
    public static int[] maxSlidingWindowBST(int[] nums, int k) {
        int n = nums.length;

        if (k>n){
            return new int[0];
        }

        int[] maxArray  = new int[n-k +1];

        TreeSet<Element> treeSet = new TreeSet<>();
        int maxSoFar = nums[0];

        for (int i=0; i<n; i++){
            treeSet.add(new Element(nums[i], i));

            //Keep track of max so far;
            maxSoFar = Math.max(maxSoFar, nums[i]);


            if (i>=k){
                treeSet.remove(new Element(nums[i-k], i-k));
                if (maxSoFar == nums[i-k]){
                    maxSoFar = treeSet.last().value;
                }
            }

            if (i>=k-1){
                maxArray[i-k+1] = maxSoFar;
            }
        }
        return maxArray;
    }

}

class Element implements Comparable<Element>{

    int value;
    int index;

    public Element(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Element other) {
        if (this.value!= other.value){
            return Integer.compare(this.value, other.value);
        }
        return Integer.compare(this.index, other.index);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return value == element.value && index == element.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, index);
    }


}