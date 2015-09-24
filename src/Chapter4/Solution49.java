package Chapter4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hao on 9/21/15.
 */
public class Solution49 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.print();
        List<List<Integer>> sequences = getBSTSequences(root);
        for (List<Integer> seq : sequences) {
            System.out.println(seq);
        }
    }

    // get all possible BST sequences
    public static List<List<Integer>> getBSTSequences(TreeNode root) {
        List<List<Integer>> sequences = new ArrayList<>();
        if (root == null) {
            // deal with null, return empty list
            List<Integer> emptyList = new ArrayList<>();
            sequences.add(emptyList);
            return sequences;
        }
        List<List<Integer>> left_seq = getBSTSequences(root.left);
        List<List<Integer>> right_seq = getBSTSequences(root.right);
        List<Integer> seq = new ArrayList<>();
        seq.add(root.val);  // add prefix to make sure elements in seq are in relative order
        for (List<Integer> left : left_seq) {
            for (List<Integer> right : right_seq) {
                genSequences(left, 0, right, 0, seq, sequences);
            }
        }
        return sequences;
    }

    // permutate, and preserve the relative order in each list
    private static void genSequences(List<Integer> list1, int start1, List<Integer> list2, int start2,
                                     List<Integer> seq, List<List<Integer>> sequences) {
        if (start1 >= list1.size() && start2 >= list2.size()) {
            sequences.add(new ArrayList<>(seq));
            return;
        }
        if (start1 < list1.size()) {
            seq.add(list1.get(start1));
            genSequences(list1, start1 + 1, list2, start2, seq, sequences);
            seq.remove(seq.size() - 1);
        }
        if (start2 < list2.size()) {
            seq.add(list2.get(start2));
            genSequences(list1, start1, list2, start2 + 1, seq, sequences);
            seq.remove(seq.size() - 1);
        }
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
