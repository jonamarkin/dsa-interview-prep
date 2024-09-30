package leetcode.blind75.binarysearch;

public class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {

        int left =1; //min eating speed
        int right = 0; //to find max speed.. will be set to max pile size

        //Find max pile size
        for (int pile : piles){
            right = Math.max(right, pile);
        }

        //Binary search
        while (left < right){
            int mid = left +(right-left)/2;
            if(canFinish(piles, mid, h)){
                right = mid;
            }else{
                left = mid +1;
            }
        }

        return left;
    }

    private boolean canFinish(int[] piles, int k, int h) {
        int hoursNeeded = 0;
        for (int pile: piles){
            //Calculate hours needed for current pile
            hoursNeeded +=(pile + k-1)/k; /// Equivalent to Math.ceil(pile / k)

        }

        return hoursNeeded<=h;
    }
}
