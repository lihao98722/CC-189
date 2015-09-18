package Chapter2;

import java.util.List;

/**
 * Created by Hao on 9/18/15.
 */
public class Solution22 {

    public static void main(String[] args) {
        Solution22 sol22 = new Solution22();
        int[] values = {2, 1, 2, 2, 5, 3, 5, 15, 1, 8};
        ListNode head = sol22.createList(values);
        sol22.printList(head);
        ListNode pt = sol22.getKthToLast(head, 3);
        System.out.println(pt.val);
    }

    public ListNode getKthToLast(ListNode head, int k) {
        ListNode p1 = head;
        ListNode p2 = head;
        // forward by k steps
        for (int step = 0; step < k; ++step) {
            p2 = p2.next;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
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
