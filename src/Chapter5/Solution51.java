package Chapter5;

import java.util.Arrays;

/**
 * Created by Hao on 10/1/15.
 */
public class Solution51 {

    public static void main(String[] args) {
        int n = 0;
        int m = 0x0000ffff;
        int result = insertBits(n, m, 5, 20);
        printBits(n);
        printBits(m);
        printBits(result);
    }

    public static int insertBits(int n, int m, int i, int j) {
        int rightPart = n % (1 << i);
        int leftPart = n / (1 << (j + 1));
        return leftPart + (m << i) + rightPart;
    }

    private static void printBits(int n) {
        int[] bits = new int[32];
        for (int pos = 0; pos < 32; ++pos) {
            bits[pos] = (n >> (31 - pos)) & 1;
        }
        System.out.println(Arrays.toString(bits));
    }
}
