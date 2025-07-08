package companies.gs;

public class ArrayGrouping {

    public static void groupPosNegInPlace(int[] arr) {
        int i = 0;
        int j = arr.length - 1;

        while(i < j){
            if(arr[i] < 0){
                i++;
            }else if(arr[j] > 0){
                j--;
            }else{
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
    }

    public static void stableGroupPosNeg(int[] arr) {
        for(int i=0; i<arr.length; i++){
            if(arr[i] < 0){
                int j = i;
                while(j > 0 && arr[j-1] > 0){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    j--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {-1, 2, -3, 4, -5, 6, 7, -8, 9};
        //groupPosNegInPlace(arr);
        stableGroupPosNeg(arr);
        for (int i: arr){
            System.out.print(i + " ");
        }
    }
}
