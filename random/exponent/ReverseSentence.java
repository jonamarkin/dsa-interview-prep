package random.exponent;

public class ReverseSentence {

    /*
    You are given an array of characters arrthat consists of sequences of characters separated by space characters.
    Each space-delimited sequence of characters defines a word.
    Implement a function reverseWords that reverses the order of the words in the array in the most efficient manner.

    Explain your solution and analyze its time and space complexities.
     */


    static char[] reverseWords(char[] arr) {
        // your code goes here

        reverseArray(arr, 0, arr.length-1);

        int start = 0;
        for(int end = 0; end<=arr.length; end++){
            if(end==arr.length || arr[end] ==' '){
                reverseArray(arr, start, end-1);
                start = end+1;
            }

        }

        return arr;

    }

    static void reverseArray(char[] arr, int left, int right){
        while(left< right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        // debug your code below
        char[] arr = { 'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' };
        char[] result = reverseWords(arr);

        System.out.print("Reversed words array: ");
        for (char ch : result) {
            System.out.print(ch);
        }
        System.out.println();
    }
}
