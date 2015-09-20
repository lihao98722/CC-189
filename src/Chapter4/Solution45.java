package Chapter4;

import java.util.Stack;

/**
 * Created by Hao on 9/20/15.
 */
public class Solution45 {

    public static boolean isValidBST(TreeNode root) {
        Stack<Integer> stk = new Stack<>();
        return isValidBST(root, stk);
    }

    private static boolean isValidBST(TreeNode root, Stack<Integer> stk) {
        if (root != null) {
            if (!isValidBST(root.left, stk)) {
                return false;
            }
            // for a BST, in-order traversal should be in increasing order.
            if (!stk.empty() && root.val <= stk.peek()) {
                return false;
            }
            stk.push(root.val);
            if (!isValidBST(root.right, stk)) {
                return false;
            }
        }
        return true;
    }

    private static class TreeNode {
        public TreeNode(int val) {
            this.val = val;
        }

        int val;
        TreeNode left;
        TreeNode right;
    }
}
