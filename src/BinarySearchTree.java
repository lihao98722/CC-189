import java.util.Arrays;

/**
 * Created by Hao on 9/25/15.
 */
public class BinarySearchTree<T extends Comparable<T>> {

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int[] datas = {3, 4, 6, 5, 2, 0, 5, 9, 1};
        System.out.println(Arrays.toString(datas));
        for (int data : datas) {
            bst.insert(data);
        }
        bst.print();
        TreeNode<Integer> found = bst.find(6);
        if (found != null) {
            System.out.println("found: " + found.data);
        } else {
            System.out.println("No found");
        }
        bst.delete(1);
        bst.print();
        System.out.println();
        System.out.println();

        bst.delete(0);
        bst.print();
        System.out.println();
        System.out.println();

        bst.delete(3);
        bst.print();
    }

    public void delete(T val) {
        TreeNode<T> parent = root;
        TreeNode<T> t = root;
        while (t != null) {
            if (t.data.equals(val)) {
                if (t.left == null && t.right == null) {  // for leaf
                    deleteLeaf(parent, t);
                } else if (t.left == null || t.right == null) {  // for node with single child
                    deleteNodeWithSingleChild(parent, t);
                } else {  // for node with two children
                    deleteNodeWthTwoChildren(parent, t);
                }
                return;
            } else if (t.data.compareTo(val) > 0) {
                parent = t;
                t = t.left;
            } else {
                parent = t;
                t = t.right;
            }
        }
    }

    private void deleteLeaf(TreeNode<T> parent, TreeNode<T> t) {
        if (parent.left == t) {
            parent.left = null;
        } else if (parent.right == t) {
            parent.right = null;
        } else {  // for root
            root = null;
        }
    }

    private void deleteNodeWithSingleChild(TreeNode<T> parent, TreeNode<T> t) {
        if (parent.left == t) {
            parent.left = t.left == null ? t.right : t.left;
        } else if (parent.right == t) {
            parent.right = t.left == null ? t.right : t.left;
        } else {  // for root
            root = t.left == null ? t.right : t.left;
        }
    }

    private void deleteNodeWthTwoChildren(TreeNode<T> parent, TreeNode<T> t) {
        // find the leftmost node in its right subtree
        TreeNode<T> leftmost = t.right;
        while (leftmost.left != null) {
            leftmost = leftmost.left;
        }
        T temp = leftmost.data;
        delete(leftmost.data);
        t.data = temp;
    }

    public TreeNode<T> find(T val) {
        TreeNode<T> t = root;
        while (t != null) {
            if (t.data.equals(val)) {
                return t;
            } else if (t.data.compareTo(val) > 0) {
                t = t.left;
            } else {
                t = t.right;
            }
        }
        return null;
    }

    public void insert(T newData) {
        TreeNode<T> newNode = new TreeNode<>(newData);
        if (root == null) {
            root = newNode;
            return;
        }
        TreeNode<T> t = root;
        while (t != null) {
            if (t.data.compareTo(newData) > 0) {
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

    public void print() {
        print(root, 0);
    }

    private void print(TreeNode<T> root, int level) {
        if (root == null) {
            return;
        }
        print(root.right, level + 1);
        if (level == 0) {
            System.out.println(root.data);
        } else {
            for (int l = 0; l < level - 1; ++l) {
                System.out.print("|\t");
            }
            System.out.println("|---" + root.data);
        }
        print(root.left, level + 1);
    }

    private TreeNode<T> root;

    private static class TreeNode<T> {
        public TreeNode(T data) {
            this.data = data;
            left = right = null;
        }

        private T data;
        private TreeNode left;
        private TreeNode right;
    }

}
