package Chapter5;

/**
 * Created by Hao on 10/2/15.
 */
public class Solution55 {

    // ((n & (n - 1)) == 0) means n is an integer that has exactly one 1 in its binary form,
    // and so n is the power of 2.

    public static void main(String[] args) {
        int num = 100;
        for (int n = 0; n < num; ++n) {
            if ((n & (n - 1)) == 0) {
                System.out.print(n + " ");
            }
        }
    }
}
