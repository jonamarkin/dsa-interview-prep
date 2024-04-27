package hackerrank.week3;

public class PageCount {
//    public static int pageCount(int n, int p) {
//        int turnsFromFront = Math.floorDiv(p, 2);
//        int turnsFromBack = 0;
//        if(n %2 ==0){
//            turnsFromBack = Math.floorDiv((n-p +1), 2);
//        }else{
//            turnsFromBack = Math.floorDiv((n-p), 2);
//        }
//
//        return Math.min(turnsFromFront, turnsFromBack);
//
//    }
//
//
//    public static void main(String[] args) {
//        System.out.println(pageCount(5, 3));
//    }




        public static void main(String[] args) {
            int result = f(7);
            System.out.println("Result: " + result);
        }

        public static int f(int n) {
            int c = 0;
            while (n >= 0) {
                n = n - 2;
                c = c + n -2;
            }
            return c ;
        }



}