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
}
