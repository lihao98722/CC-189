package Chapter4;

import java.util.*;

/**
 * Created by Hao on 9/19/15.
 */
public class Solution43 {

    public static void main(String[] args) {
        TreeNode root = getRandomTree(10);
        root.print();
        List<ListNode> listOfDepth = getListOfDepth(root);
        for (ListNode list : listOfDepth) {
            list.print();
        }
    }

    public static List<ListNode> getListOfDepth(TreeNode root) {
        List<ListNode> listOfDepth = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // BFS
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            // create a list for each level
            for (;levelSize > 0; --levelSize) {
                TreeNode treeNode = queue.remove();
                cur.next = new ListNode(treeNode.val);
                cur = cur.next;
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            listOfDepth.add(dummy.next);
        }
        return listOfDepth;
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

    private static class ListNode<T> {
        public ListNode(T val) {
            this.val = val;
            this.next = null;
        }

        // print the list as a sequence
        public void print() {
            ListNode<T> cur = this;
            while (cur != null) {
                System.out.print(cur.val + " ");
                cur = cur.next;
            }
            System.out.println();
        }

        T val;
        ListNode next;
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
