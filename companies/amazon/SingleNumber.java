package companies.amazon;

import java.util.HashMap;

public class SingleNumber {
    public int singleNumber(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for (int num : map.keySet()){
            if(map.get(num)==1){
                return num;
            }
        }

        return 0;
    }

    public int singleNumber2(int[] nums) {
        int xor = 0;

        for (int num : nums){
            xor = xor ^ num;
        }

        return xor;
    }
}
