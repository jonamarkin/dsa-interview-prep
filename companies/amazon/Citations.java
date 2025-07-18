package companies.amazon;

import java.util.Arrays;

public class Citations {

    public int hIndex(int[] citations) {

        /*
        Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper,
        return the researcher's h-index.

        According to the definition of h-index on Wikipedia:
        The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
         */

        int n = citations.length;
        Arrays.sort(citations);


        for(int i=0; i<n; i++){
            int hIndex = n-i;
            if(citations[i]>=hIndex){
                return hIndex;
            }
        }

        return 0;
    }
}
