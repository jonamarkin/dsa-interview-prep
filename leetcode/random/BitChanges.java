package leetcode.random;

public class BitChanges {

    /*
    You are given two positive integers n and k.

    You can choose any bit in the binary representation of n that is equal to 1 and change it to 0.

    Return the number of changes needed to make n equal to k. If it is impossible, return -1.
     */

    public static void main(String[] args) {

        System.out.println(minChanges(13,4));

    }

    public static int minChanges(int n, int k) {

        String nBin = Integer.toBinaryString(n);
        String kBin = Integer.toBinaryString(k);

        int maxLength = Math.max(nBin.length(), kBin.length());
        nBin = String.format("%" + maxLength + "s", nBin).replace(' ', '0');
        kBin = String.format("%" + maxLength + "s", kBin).replace(' ', '0');

        System.out.println(nBin);
        System.out.println(kBin);

        char[] nBinArray = nBin.toCharArray();
        char[] kBinArray = kBin.toCharArray();

        int changes = 0;

        for (int i =0; i<nBinArray.length; i++){
            if (nBinArray[i]=='1' && kBinArray[i]=='0'){
                nBinArray[i] = '0';
                changes++;
            }else if (nBinArray[i]=='0' && kBinArray[i]=='1'){
                return -1;
            }
        }

        return changes;
    }

}
