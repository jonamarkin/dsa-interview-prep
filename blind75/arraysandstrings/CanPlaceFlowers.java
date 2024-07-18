package blind75.arraysandstrings;

public class CanPlaceFlowers {
    /*
    You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

    Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n,
    return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
     */

    public static void main(String[] args) {

        int[] flowerbed = {1,0,0,0,1};
        int n = 1;

        System.out.println(canPlaceFlowers2(flowerbed, 1));
    }


    /*
    Wrong solution because it does not check the adjacency issue
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        int planted = 0;

        int plantable = Math.ceilDiv(flowerbed.length, 2);

        for (int plot: flowerbed){
            if (plot==1){
                planted++;
            }
        }

        return plantable - planted >= n;
    }

    public static boolean canPlaceFlowers2(int[] flowerbed, int n) {

        /*We are only interested in the slots where it is 0
        We loop and check side and side of the slots with 0
        We set the value to 1 if both sides are 0 and decrese n
        Return true immediatel when n rechaes 0
         */

        for (int i=0; i<flowerbed.length; i++){
            if (flowerbed[i]==0){
                //Check for empty left and empty right
                //
                boolean checkLeft = (i==0) || (flowerbed[i-1]==0);
                boolean checkRight = (i==flowerbed.length-1) || (flowerbed[i+1]==0);

                if (checkLeft && checkRight){
                    n--;
                    flowerbed[i]=1;

                    if (n==0){
                        return true;
                    }
                }

            }
        }

        return n<=0;
    }
}
