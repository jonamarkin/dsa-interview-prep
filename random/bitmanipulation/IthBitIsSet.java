package random.bitmanipulation;

public class IthBitIsSet {

    public static boolean ithBitIsSet(int n, int i){
        //Use left shift operator

        return (n & (1<<i))!=0;
    }

    public static boolean ithBitIsSet2(int n, int i){
        //Use left shift operator

        return (n & (n>>i))!=0;
    }

    public static void main(String[] args) {
        System.out.println(ithBitIsSet2(13,2));
    }
}
