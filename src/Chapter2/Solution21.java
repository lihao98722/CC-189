package Chapter2;

/**
 * Created by Hao on 9/18/15.
 */
public class Solution21 {

    public static void main(String[] args) {
        Solution21 sol21 = new Solution21();
        int[] values = {2, 1, 2, 2, 5, 3, 5, 15, 1, 8};
        ListNode head = sol21.createList(values);
        sol21.printList(head);
        sol21.removeDuplicates(head);
        sol21.printList(head);
    }

    public void removeDuplicates(ListNode head) {
        if (head == null) {
            return;
        }
        // for each node, traverse the list to delete its duplicates
        for (ListNode pt = head; pt != null; pt = pt.next) {
            ListNode pre = pt;
            ListNode cur = pre.next;
            while (cur != null) {
                if (pt.val == cur.val) {
                    // delete duplicates
                    pre.next = cur.next;
                    cur = pre.next;
                } else {
                    pre = cur;
                    cur = cur.next;
                }
            }
        }
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

    /* other approaches:
     * 1. store the appeared values(HashSet), then traverse to delete duplicates, running time O(n), space O(n);
     * 2. merge-sort the list in the first place to gather duplicates, then traverse once to delete them,
     * running time O(nlogn), space O(1).
     */
}
