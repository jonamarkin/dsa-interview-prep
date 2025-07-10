package companies.gs;

public class SecondSmallest {

    public static int findSecondSmallest(int[] arr) {

        if(arr == null || arr.length < 2){
            System.out.println("Array is null or has less than 2 elements");
            return -1;
        }

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : arr){
            if(num < smallest){
                secondSmallest = smallest;
                smallest = num;
            }else if(num < secondSmallest && num != smallest){
                secondSmallest = num;
            }
        }

        if(secondSmallest == Integer.MAX_VALUE){
            System.out.println( "No distinct second smallest element");
            return -1;
        }

        return secondSmallest;
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 2, 8, 1, 9, 3}; // Expected: 2
        System.out.println("Second smallest in arr1: " + findSecondSmallest(arr1));

        int[] arr2 = {10, 5, 20, 5, 15}; // Expected: 10
        System.out.println("Second smallest in arr2: " + findSecondSmallest(arr2));

        int[] arr3 = {7, 7, 7, 7}; // Expected: Integer.MAX_VALUE (or a message)
        System.out.println("Second smallest in arr3: " + findSecondSmallest(arr3));

        int[] arr4 = {1, 2}; // Expected: 2
        System.out.println("Second smallest in arr4: " + findSecondSmallest(arr4));

        int[] arr5 = {1}; // Expected: Integer.MAX_VALUE (or a message)
        System.out.println("Second smallest in arr5: " + findSecondSmallest(arr5));

        int[] arr6 = {3, 1, 2, 3, 2}; // Expected: 2
        System.out.println("Second smallest in arr6: " + findSecondSmallest(arr6));
    }
}
