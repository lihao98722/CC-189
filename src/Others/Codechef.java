/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner in = new Scanner(System.in);
        int chefCount = Integer.parseInt(in.nextLine());
        List<TreeNode> chefs = buildNodes(in, chefCount);
        buildReports(in, chefs);
        calSize(chefs.get(0));
        int queries = Integer.parseInt(in.nextLine());
        List<Boolean> results = new ArrayList<>();
        for (int num = 1; num <= queries; ++num) {
            int newchefCount = Integer.parseInt(in.nextLine());
            List<TreeNode> newchefs = buildNodes(in, newchefCount);
            buildReports(in, newchefs);
            calSize(newchefs.get(0));
            results.add(isSubtree(chefs.get(0), newchefs.get(0)));
        }
        for (boolean res : results) {
            if (res == true) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static void buildReports(Scanner in, List<TreeNode> chefs) {
        for (int num = 1; num <= chefs.size() - 1; ++num) {
            String input = in.nextLine();
            String[] strs = input.split(" ");
            TreeNode senior = chefs.get(Integer.parseInt(strs[0]) - 1);
            TreeNode reporting = chefs.get(Integer.parseInt(strs[1]) - 1);
            if ("M".equals(strs[2])) {
                senior.left = reporting;
            } else {
                senior.right = reporting;
            }
        }
    }

    private static List<TreeNode> buildNodes(Scanner in, int chefCount) {
        List<TreeNode> chefs = new ArrayList<>();
        for (int num = 1; num <= chefCount; ++num) {
            int age = Integer.parseInt(in.nextLine());
            chefs.add(new TreeNode(age));
        }
        return chefs;
    }

    private static int calSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        root.size = calSize(root.left) + calSize(root.right) + 1;
        return root.size;
    }

    public static boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root1.size > root2.size) {
            return isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
        } else if (root1.size == root2.size) {
            return isSameTree(root1, root2);
        } else {
            return false;
        }
    }

    private static boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 != null && root2 != null) {
            return root1.val == root2.val && isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
        } else {
            return false;
        }
    }

    private static class TreeNode {
        public TreeNode(int val) {
            this.val = val;
            left = right = null;
            size = 0;
        }
        int val;  // age
        TreeNode left;  // M report
        TreeNode right;  // E report
        int size;
    }
}
