package Chapter4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Hao on 9/19/15.
 */
public class Solution42 {

    public static void main(String[] args) {
        int[] elements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = getMinBST(elements);
        root.print();
    }

    // public interface
    public static TreeNode getMinBST(int[] elements) {
        return getMinBST(elements, 0, elements.length - 1);
    }

    // private interface, the true implementation method
    private static TreeNode getMinBST(int[] elements, int start_pos, int end_pos) {
        if (start_pos > end_pos) {
            return null;
        }
        // get mid pos
        int pos = start_pos + ((end_pos - start_pos) >> 1);
        TreeNode root = new TreeNode(elements[pos]);
        root.left = getMinBST(elements, start_pos, pos - 1);
        root.right = getMinBST(elements, pos + 1, end_pos);
        return root;
    }

    private static class TreeNode {
        public TreeNode(int val) {
            this.val = val;
        }

        public void print() {
            print(this, 0);
        }

        // DFS to print tree
        private void print(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            print(root.right, level + 1);
            if (level == 0) {
                System.out.println(root.val);
            } else {
                for (int l = 0; l < level - 1; ++l) {
                    System.out.print("|\t");
                }
                System.out.println("|---" + root.val);
            }
            print(root.left, level + 1);
        }

        int val;
        TreeNode left;
        TreeNode right;
    }


}
