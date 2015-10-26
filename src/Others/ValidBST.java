package Others;

import java.util.*;

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

    public static String validBST(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> stk = new Stack<>();
        for (int node : preorder) {
            if (node < low) {
                return "NO";
            }
            while (!stk.isEmpty() && stk.peek() < node) {
                low = stk.pop();
            }
            stk.push(node);
        }
        return "YES";
    }
}
