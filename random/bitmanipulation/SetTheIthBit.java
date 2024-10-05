package random.bitmanipulation;

public class SetTheIthBit {

    public static int setIthBit(int n, int i){

        int set = n | (1 << i);

        return set;
    }

    public static void main(String[] args) {
        System.out.println(setIthBit(9, 2));
    }
}
