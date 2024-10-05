package random.bitmanipulation;

public class MinimumBitFlips {
    //Minimum bit flips to convert a number to another

    public static int minimumBitFlips(int start, int goal){

        /*
        A bit flip is needed at each position where the bits differ
        XOR returns 1 if the corresponding bits are different and 0 if they are the same
        Hence the number of 1s in the XOR will give the number of bit flips needed
         */

        int xor = start ^ goal;

        int count = 0;
        while (xor!=0){
            count+=xor & 1; //Increment count if last bit is 1
            xor >>=1; // Shift right by 1 to check next bit
        }

        return count;
    }
}
