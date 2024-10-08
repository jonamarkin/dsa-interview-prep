package random.bitmanipulation;

public class CountNumOfSetBits {
    public static int numberOfSetBits(int n){
        int count = 0;

        while(n>1){
            if (n%2 ==1){
                count+=1;
            }
            n/=2;
        }

        if (n==1) count+=1;

        return count;
    }


    public static int numberOfSetBits2(int n){
        int count = 0;

        while(n>1){
            count+= n&1;
            n = n>>1;
        }

        if (n==1) count+=1;

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSetBits2(13));
    }
}
