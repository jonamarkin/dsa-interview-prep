package companies.amazon;

import java.util.HashMap;

public class SingleNumberII {

    public int singleNumber(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for (int num : map.keySet()){
            if(map.get(num)<3){
                return num;
            }
        }

        return 0;
    }

    public int singleNumber2(int[] nums) {
        //Declare array to store the count of each bit position
        int[] bitCounts = new int[32];

        //Count the number rof times each bit is set across all numbers
        for (int num : nums){
            for (int i=0; i<32; i++){
                //Check if the ith bit is set
                if ((num & (1<<i))!=0){
                    bitCounts[i]++;
                }
            }
        }

        //Reconstruct the single number from the bit counts
        int result = 0;
        for (int i=0; i<32; i++){
            if (bitCounts[i] %3 !=0){
                result |=(1<<i);
            }
        }

        return result;
    }
}
