package random.bitmanipulation;

public class ToggleIthBit {
    public static int setIthBit(int n, int i){


        return n ^ (1<<i);
    }

    public static void main(String[] args) {
        System.out.println(setIthBit(9, 2));
    }
}
