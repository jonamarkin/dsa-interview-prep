package companies.gs;

public class PowerOfTen {

    public static boolean isPowerOfTen(int n) {
        if(n <= 0){
            return false;
        }

        while ( n> 1){
            if(n % 10 != 0){
                return false;
            }
            n /=10;
        }

        return true;
    }
}
