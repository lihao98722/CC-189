package Chapter5;

import java.util.Arrays;

/**
 * Created by Hao on 10/2/15.
 */
public class Solution57 {

    public static void main(String[] args) {
        int n = 0x5555aaaa;
        printBits(n);
        printBits(swapBits(n));
    }

    public static int swapBits(int n) {
        // get odd bits
        int oddBits = n & 0xaaaaaaaa;
        // get even bits
        int evenBits = n & 0x55555555;
        return ((evenBits << 1) | (oddBits >>> 1));
    }

    private static void printBits(int n) {
        int[] bits = new int[32];
        for (int pos = 0; pos < 32; ++pos) {
            bits[pos] = (n >> (31 - pos)) & 1;
        }
        System.out.println(Arrays.toString(bits));
    }
}
