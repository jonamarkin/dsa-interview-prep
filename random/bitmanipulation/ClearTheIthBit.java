package random.bitmanipulation;

public class ClearTheIthBit {

    public static int clearIthBit(int n, int i){



        return n & ~(1<<i);
    }

    public static void main(String[] args) {
        System.out.println(clearIthBit(13, 2));
    }
}
