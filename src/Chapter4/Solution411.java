package Chapter4;

import java.util.Random;

/**
 * Created by Hao on 9/22/15.
 */
public class Solution411 {

    public class TreeNode<T> {
        public TreeNode(T val) {
            this.val = val;
            this.left = this.right = null;
            this.size = 1;
        }

        public int size() {
            return this.size;
        }

        public TreeNode<T> getRandomNode() {
            int leftSize = left != null ? left.size() : 0;
            Random rand = new Random();
            int num = rand.nextInt(this.size);
            if (num < leftSize) {
                return left.getRandomNode();
            } else if (num == leftSize) {
                return this;
            } else {
                return right.getRandomNode();
            }
        }

        public TreeNode<T> find(T target) {
            if (val == target) {
                return this;
            } else {
                TreeNode l = left != null ? left.find(target) : null;
                if (l != null) {
                    return l;
                } else {
                    return right != null ? right.find(target) : null;
                }
            }
        }

        T val;
        TreeNode left;
        TreeNode right;
        int size;  // size of tree (consider this node as root)
    }
}
