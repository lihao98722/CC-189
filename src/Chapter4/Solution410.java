package Chapter4;

/**
 * Created by Hao on 9/22/15.
 */
public class Solution410 {

    public static boolean checkSubtree(TreeNode t1, TreeNode t2) {
        // assume empty tree is a subtree of any tree
        if (t2 == null) {
            return true;
        }
        if (t1 == null) {
            return false;
        }
        return (t1.val == t2.val && isSameTree(t1, t2)) || checkSubtree(t1.left, t2) || checkSubtree(t1.right, t2);
    }

    private static boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        } else {  // both t1 and t2 are not null
            return t1.val == t2.val && isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
        }
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
