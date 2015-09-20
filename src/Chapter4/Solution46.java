package Chapter4;

/**
 * Created by Hao on 9/20/15.
 */
public class Solution46 {

    // the left-most node in its right subtree is its in-order successor.
    public static TreeNode getSuccessor(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        // if it has right child, then the left-most node in its right subtree is its in-order successor.
        if (treeNode.right != null) {
            TreeNode leftMost = treeNode.right;
            while (leftMost.left != null) {
                leftMost = leftMost.left;
            }
            return leftMost;
        } else {  // it does not have right child
            if (treeNode.parent.left == treeNode) {  // if it is a left child, the parent is its successor.
                return treeNode.parent;
            } else {  // if it is a right child
                TreeNode p = treeNode.parent;
                TreeNode t = treeNode;
                // find the parent that is a left child of its parent.
                while (p != null && p.right == t) {
                    t = p;
                    p = p.parent;
                }
                return p;
            }
        }
    }

    private static class TreeNode {
        public TreeNode(int val) {
            this.val = val;
        }

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
    }
}
