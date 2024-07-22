package faang.amazon;

import java.util.ArrayList;
import java.util.List;

public class NumberOfItems {

    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        // Write your code here

        int len = s.length();
        int[] leftPipe = new int[len];
        int[] rightPipe = new int[len];
        int[] prefixSum = new int[len];

        int lastPipe = -1;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '|') {
                lastPipe = i;
            }

            leftPipe[i] = lastPipe;
        }

        lastPipe = -1;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                lastPipe = i;
            }

            rightPipe[i] = lastPipe;
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '*') {
                count++;
            }
            prefixSum[i] = count;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < startIndices.size(); i++) {
            int start = startIndices.get(i) - 1;
            int end = endIndices.get(i) - 1;

            int leftIndex = rightPipe[start];
            int rightIndex = leftPipe[end];

            if (leftIndex != -1 && rightIndex != -1 && leftIndex < rightIndex) {
                result.add(prefixSum[rightIndex] - prefixSum[leftIndex]);
            } else {
                result.add(0);
            }
        }

        return result;

    }
}
