package Others;

import java.util.Scanner;

/**
 * Created by Hao on 10/20/15.
 */
public class ValidBST {

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        int count = Integer.parseInt(in.nextLine());
        for(int i = 0; i < count; ++i) {
            final int N = Integer.parseInt(in.nextLine());
            String[] spilt = in.nextLine().split(" ");
            int[] A = new int[spilt.length];
            for (int pos = 0; pos < spilt.length; ++pos) {
                A[pos] = Integer.parseInt(spilt[pos]);
            }
            //
            System.out.println(validBST(A));
        }
    }

    public static String validBST(int[] A) {
        int prev = 0;
        int root = 0;
        boolean right = false;
        for (int num : A) {
            if (prev == 0) {
                prev = root = num;
                continue;
            }
            if (right) {
                if (num < prev) {
                    return "NO";
                } else if (num < root) {
                    right = false;
                    prev = root;
                    root = num;
                }
            } else {
                if (num > prev) {
                    root = num;
                    right = true;
                    continue;
                }
            }
            if (num > prev) {
                right = true;
            }
            if (num > root) {
                prev = root;
                root = num;
            }
        }
        return "YES";
    }
}
