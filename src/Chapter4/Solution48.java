package Chapter4;

/**
 * Created by Hao on 9/21/15.
 */
public class Solution48 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode l_subtree = lowestCommonAncestor(root.left, p, q);
        TreeNode r_subtree = lowestCommonAncestor(root.right, p, q);
        // if one is in the left subtree, the other one is in the right subtree, then root is their lowest common ancestor.
        if (l_subtree != null && r_subtree != null) {
            return root;
        } else {
            return l_subtree == null? r_subtree: l_subtree;
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
