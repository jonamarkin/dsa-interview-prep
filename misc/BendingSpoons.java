package misc;

import java.util.ArrayList;
import java.util.List;

public class BendingSpoons {


        public static int andList(List<Integer> x) {
            // Start with the first element of the list, assuming the list is non-empty.
            int result = x.get(0);
            // Perform bitwise AND operation with every subsequent element in the list.
            for (int i = 1; i < x.size(); i++) {
                result &= x.get(i);
            }
            return result;
        }

        public static int xorList(List<Integer> x) {
            // Start with the first element of the list, assuming the list is non-empty.
            int result = x.get(0);
            // Perform bitwise XOR operation with every subsequent element in the list.
            for (int i = 1; i < x.size(); i++) {
                result ^= x.get(i);
            }
            return result;
        }


    // Function to generate all contiguous sublists of a given list
    public static List<List<Integer>> getAllSublists(List<Integer> x) {
        List<List<Integer>> sublists = new ArrayList<>();
        for (int start = 0; start < x.size(); start++) {
            for (int end = start; end < x.size(); end++) {
                sublists.add(new ArrayList<>(x.subList(start, end + 1)));
            }
        }
        return sublists;
    }

    public static int f(List<Integer> x) {
        if (x.isEmpty()) {
            return 0; // Return 0 when list is empty
        }
        List<List<Integer>> sublists = getAllSublists(x);
        List<Integer> xorValues = new ArrayList<>();
        for (List<Integer> sublist : sublists) {
            xorValues.add(xorList(sublist));
        }
        return andList(xorValues);
    }

    public static int f_eff(List<Integer> x) {
        if (x.isEmpty()) {
            return 0; // Edge case: empty list
        }

        // Create a prefix XOR array
        int[] prefixXor = new int[x.size()];
        prefixXor[0] = x.get(0);
        for (int i = 1; i < x.size(); i++) {
            prefixXor[i] = prefixXor[i - 1] ^ x.get(i);
        }

        // Variable to store the final AND result, start with all bits set (all 1s in binary)
        int finalAndResult = prefixXor[0]; // Initialize with the XOR of the first element (first sublist)

        // Compute XOR of all sublists and fold AND operation directly
        for (int start = 0; start < x.size(); start++) {
            for (int end = start; end < x.size(); end++) {
                int sublistXor = (start == 0) ? prefixXor[end] : prefixXor[end] ^ prefixXor[start - 1];
                finalAndResult &= sublistXor;
            }
        }

        return finalAndResult;
    }

        public static void main(String[] args) {
            // Example usage of the functions
            List<Integer> exampleList = List.of(3, 5, 1);
            System.out.println("AND of list: " + andList(exampleList)); // Expected output: 1
            System.out.println("XOR of list: " + xorList(exampleList)); // Expected output: 7


            System.out.println("f(X) = " + f(exampleList));
            System.out.println("f(X) = " + f_eff(exampleList));
        }


}
