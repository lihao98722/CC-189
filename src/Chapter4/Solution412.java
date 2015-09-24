package Chapter4;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Hao on 9/21/15.
 */
public class Solution412 {

    public static void main(String[] args) throws IOException {
        TreeNode root = getRandomTree(10);
        root.print();
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        int sum = getPathsSum(root, target);
        System.out.println(sum);
    }

    // get the number of all possible paths
    public static int getPathsSum(TreeNode root, final int target) {
        if (root == null) {
            return 0;
        }
        return getPaths(root, target) + getPathsSum(root.left, target) + getPathsSum(root.right, target);
    }

    // get the number of paths starting from this node
    private static int getPaths(TreeNode root, final int target) {
        if (root == null) {
            return 0;
        }
        int leftSum = getPaths(root.left, target - root.val);
        int rightSum = getPaths(root.right, target - root.val);
        return leftSum + rightSum + (target == root.val? 1: 0);
    }

    // create a tree randomly
    private static TreeNode getRandomTree(int n) {
        int[] elements = new int[n];
        for (int pos = 0; pos < n; ++pos) {
            elements[pos] = pos + 1;
        }
        Collections.shuffle(Arrays.asList(elements));
        return getRandomTree(elements, 0, elements.length - 1);
    }

    private static TreeNode getRandomTree(int[] elements, int start_pos, int end_pos) {
        if (start_pos > end_pos) {
            return null;
        }
        // because rand.nextInt(n), n should strictly be positive.
        if (start_pos == end_pos) {
            return new TreeNode(elements[start_pos]);
        }
        Random rand = new Random();
        int pos = rand.nextInt(end_pos - start_pos) + start_pos;
        TreeNode root = new TreeNode(elements[pos]);
        root.left = getRandomTree(elements, start_pos, pos - 1);
        root.right = getRandomTree(elements, pos + 1, end_pos);
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
