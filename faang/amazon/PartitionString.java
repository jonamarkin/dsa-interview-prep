package faang.amazon;

import java.util.HashSet;
import java.util.Set;

public class PartitionString {
    public int partitionString(String s) {

        Set<Character> currentSubstring = new HashSet<>();
        int partitions = 1;

        for (char c : s.toCharArray()){
            if (currentSubstring.contains(c)){
                partitions++;
                currentSubstring.clear();
            }

            currentSubstring.add(c);
        }

        return partitions;
    }
}
