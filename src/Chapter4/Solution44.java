package Chapter4;

/**
 * Created by Hao on 9/20/15.
 */
public class Solution44 {

    public static boolean isBalanced(TreeNode root) {
        WarpedInt height = new WarpedInt(0);
        return isBalanced(root, height);
    }

    // use WarpedInt to get height while traversing the tree.
    public static boolean isBalanced(TreeNode root, WarpedInt height) {
        if (root == null) {
            height.value = 0;
            return true;
        }
        WarpedInt leftHeight = new WarpedInt(0);
        WarpedInt rightHeight = new WarpedInt(0);
        if (isBalanced(root.left, leftHeight) && isBalanced(root.right, rightHeight)
                && Math.abs(leftHeight.value - rightHeight.value) <= 1) {
            // update height value
            height.value = Math.max(leftHeight.value, rightHeight.value) + 1;
            return true;
        }
        return false;
    }

    private static class WarpedInt {
        public WarpedInt(int value) {
            this.value = value;
        }
        int value = 0;
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
