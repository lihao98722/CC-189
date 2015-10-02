package Chapter5;

/**
 * Created by Hao on 10/2/15.
 */
public class Solution56 {

    public static void main(String[] args) {
        int n = 15;
        int m = 29;
        System.out.println(countFlips(n, m));
    }

    public static int countFlips(final int n, final int m) {
        int x = n ^ m;
        // count the number of 1 in x
        int count = 0;
        while (x != 0) {
            ++count;
            x = x & (x - 1);
        }
        return count;
    }
}
