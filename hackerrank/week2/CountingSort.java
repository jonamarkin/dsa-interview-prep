package hackerrank.week2;

import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountingSort {

    public static void main(String[] args) {

        List<Integer> arr = Stream.of(1, 1, 3, 2, 1).collect(Collectors.toList());

        System.out.println(countingSort(arr));

    }

    public static List<Integer> countingSort(List<Integer> arr) {
        // Initialize an arraylist of size 100 with every index set to the value 0
        List<Integer> frequencyList = new ArrayList<>(Collections.nCopies(100, 0));

        // Loop through the arr, when I encounter a number I increase the index in the
        // frequencyList
        // So value in the arr must correspond to the index in the frequencyList

        for (int value : arr) {
            frequencyList.set(value, frequencyList.get(value) + 1);
        }

        return frequencyList;

    }

}