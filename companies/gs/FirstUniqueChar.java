package companies.gs;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueChar {

    public static Character firstNonRepeatingCharacter(String str) {

        if(str ==null  || str.isEmpty()){
            return null;
        }

        Map<Character, Integer> map = new LinkedHashMap<>();

        for(char c : str.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }

        return null;
    }

    public static void main(String[] args) {
        String str = "abaccdeff";
        System.out.println(firstNonRepeatingCharacter(str));
    }
}
