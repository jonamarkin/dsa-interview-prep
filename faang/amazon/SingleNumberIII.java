package faang.amazon;

import java.util.*;

public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : map.keySet()){
            if(map.get(num)==1){
                list.add(num);
            }

            if (list.size() >2){
                break;
            }
        }

        return new int[]{list.get(0), list.get(1)};
    }



}
