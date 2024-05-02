package hackerrank.week4;

public class Kangaroo {

    public static void main(String[] args) {
        System.out.println(kangaroo(0,2,5,3));
    }

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // Write your code here
        int positionk1 = x1;
        int positionk2 = x2;


        while(true){
            if(positionk2 == positionk1){
                return "YES";
            }

            if((positionk2 > positionk1 && v2>=v1) || (positionk1 >positionk2 && v1>=v2)){
                return "NO";
            }

            positionk1+=v1;
            positionk2 += v2;
        }
    }


    /*
    The kangaroos start at positions x1 and x2, with velocities v1 and v2 meters per jump, respectively.
    After n jumps, their positions will be:
    Kangaroo 1: x1 + n * v1
    Kangaroo 2: x2 + n * v2

    For them to land on the same position there must be an "n" such that after "n" steps they wull land on the same position
    Expressed as x1 + n * v1 = x2 + n * v2
    n*(v1-v2) = x2-x1

    n = x2-x1/v1-v2
     */
    public static String kangarooEfficient(int x1, int v1, int x2, int v2) {

        int deltaX = x2-x1;
        int deltaV = v1-v2;

        //Handle the case where they move at the same velocity
        if(deltaV == 0){

            //If they have the same velocity and start at same position then they jump together
            return (deltaX ==0)? "YES" : "NO";
        }

        //Check if the number of jumps is a positive number
        if(deltaX % deltaV == 0 && deltaX/deltaV >0){
            return "YES";
        }

        return "NO";
    }


}
