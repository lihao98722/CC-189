package Chapter10;

import java.util.Arrays;

/**
 * Created by Hao on 9/25/15.
 */
public class Solution1010 {

    public static void main(String[] args) {
        NumberRanker<Integer> numberRanker = new NumberRanker<>();
        int[] datas = {3, 4, 6, 5, 2, 0, 5, 9, 1};
        for (int data : datas) {
            numberRanker.track(data);
        }
        numberRanker.print();
        System.out.println(numberRanker.getRankOfNumber(5));
    }

    // use binary search tree as base structure
    // treenodes in bst contains the number of nodes in its subtrees so that we can get rank of numbers in O(n)
    private static class NumberRanker<T extends Comparable<T>> {
        public NumberRanker() {
            root = null;
        }

        public void track(T num) {
            TreeNode<T> newNode = new TreeNode<>(num);
            if (root == null) {
                root = newNode;
                return;
            }
            TreeNode<T> t = root;
            while (t != null) {
                ++t.size;
                if (t.data.compareTo(num) > 0) {
                    if (t.left == null) {
                        t.left = newNode;
                        return;
                    } else {
                        t = t.left;
                    }
                } else {
                    if (t.right == null) {
                        t.right = newNode;
                        return;
                    } else {
                        t = t.right;
                    }
                }
            }
        }

        public int getRankOfNumber(T num) {
            TreeNode<T> t = root;
            int rank = 0;
            while (t != null) {
                if (t.data.equals(num)) {
                    rank += t.left != null ? t.left.size + 1 : 0;
                    // deal with duplicates (duplicates always in the right child)
                    while (t.right != null && t.right.data == num) {
                        ++rank;
                        t = t.right;
                    }
                    return rank;
                } else if (t.data.compareTo(num) > 0) {
                    t = t.left;
                } else {
                    rank += 1 + (t.left != null ? t.left.size + 1 : 0);
                    t = t.right;
                }
            }
            // no found
            return -1;
        }

        public void print() {
            print(root, 0);
        }

        private void print(TreeNode<T> root, int level) {
            if (root == null) {
                return;
            }
            print(root.right, level + 1);
            if (level == 0) {
                System.out.println(root.data + "(" + root.size + ")");
            } else {
                for (int l = 0; l < level - 1; ++l) {
                    System.out.print("|\t");
                }
                System.out.println("|---" + root.data + "(" + root.size + ")");
            }
            print(root.left, level + 1);
        }

        private TreeNode<T> root;

        private class TreeNode<T> {
            public TreeNode(T data) {
                this.data = data;
                size = 0;
                left = right = null;
            }

            private T data;
            private int size;  // the number of nodes in its subtrees, not includes itself.
            private TreeNode left;
            private TreeNode right;
        }
    }


}
