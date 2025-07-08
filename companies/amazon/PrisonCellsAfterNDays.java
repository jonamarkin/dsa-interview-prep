package companies.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonCellsAfterNDays {

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,1,1,0,0,1};
        System.out.println(Arrays.toString(prisonAfterNDays(arr, 7)));
    }
//    public static int[] prisonAfterNDays(int[] cells, int n) {
//
//        for(int i =0; i<n; i++){
//
//            for(int j=1; j<cells.length-1; j++){
//                if ((cells[j-1]==1 && cells[j+1]==1) || (cells[j-1]==0 && cells[j+1]==0)){
//                    cells[j]=1;
//                }else{
//                    cells[j]=0;
//                }
//            }
//        }
//        cells[0] = 0;
//        cells[cells.length-1]=0;
//
//        return cells;
//    }


    public static int[] prisonAfterNDays(int[] cells, int n) {
        Map<String, Integer> seenStates = new HashMap<>();

        while(n>0){
            int[] nextCells = new int[8];

            String currentState = Arrays.toString(cells);

            if (seenStates.containsKey(currentState)){
                n%=seenStates.get(currentState)-n;
            }

            seenStates.put(currentState, n);

            if (n>0){
                n--;
                for (int i=1; i<7; i++){
                    nextCells[i] = (cells[i-1] == cells[i+1])? 1:0;
                }
                cells = nextCells;
            }
        }

        return cells;
    }

}
