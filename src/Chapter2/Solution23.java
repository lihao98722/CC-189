package Chapter2;

/**
 * Created by Hao on 9/18/15.
 */
public class Solution23 {

    public static void main(String[] args) {
        Solution23 sol23 = new Solution23();
        int[] values = {2, 1, 2, 2, 5, 3, 5, 15, 1, 8};
        ListNode head = sol23.createList(values);
        sol23.printList(head);
        ListNode midNode = sol23.getKthNode(head, 4);
        sol23.deleteNode(midNode);
        sol23.printList(head);
    }

    // copy val of the next node, and then delete next node.
    // (only valid when node is in the middle of a list.)
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    // get kth node in the list, k <= length(list)
    private ListNode getKthNode(ListNode head, int k) {
        for (int step = 0; step < k - 1; ++step) {
            head = head.next;
        }
        return head;
    }

    private void printList(ListNode head) {
        for (ListNode pt = head; pt != null; pt = pt.next) {
            System.out.print(pt.val + " ");
        }
        System.out.println();
    }

    // create a linkedlist from an array of values.
    private ListNode createList(int[] values) {
        ListNode header = new ListNode(0);
        ListNode cur = header;
        for (int val : values) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return header.next;
    }

    private class ListNode {
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
        int val;
        ListNode next;
    }
}
