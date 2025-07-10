package companies.gs;

public class RotatedArrayMinFinder {

    public static int findMin(int[] arr) {

        int low = 0;
        int high = arr.length - 1;

        while(low < high){
            int mid = low + (high - low)/2;

            if(arr[mid] < arr[high]){
                high = mid;
            }else{
                low = mid + 1;
            }
        }

        return arr[low];
    }

    public static void main(String args[]) {
        boolean result = true;
        result = result && findMin(new int[] { 3, 4, 5, 6, 1, 2 }) == 1;
        result = result && findMin(new int[] { 2, 1 }) == 1;
        result = result && findMin(new int[] { 1 }) == 1;

        try {
            findMin(null);
            result = false;
        } catch (Exception e) {
            result = result && true;
        }

        if (result) {
            System.out.println("All tests pass");
        } else {
            System.out.println("There are test failures");
        }
    }
}
