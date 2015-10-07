package Chapter8;

/**
 * Created by Hao on 10/6/15.
 */
public class Solution81 {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(getNumOfWays(n));
    }

    public static int getNumOfWays(final int n) {
        if (n < 1) {
            return -1;
        }
        int[] prev = {1, 2, 4};  // for n = 1, 2, 3, respectively
        if (n <= 3) {
            return prev[n-1];
        }
        int cur = 0;
        for (int step = 4; step <= n; ++step) {
            cur = prev[0] + prev[1] + prev[2];
            prev[0] = prev[1];
            prev[1] = prev[2];
            prev[2] = cur;
        }
        return cur;
    }
}
