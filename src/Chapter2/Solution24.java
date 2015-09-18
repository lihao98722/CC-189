package Chapter2;

/**
 * Created by Hao on 9/18/15.
 */
public class Solution24 {

    public static void main(String[] args) {
        Solution24 sol24 = new Solution24();
        int[] values = {2, 1, 2, 2, 5, 3, 5, 15, 1, 8};
        ListNode head = sol24.createList(values);
        sol24.printList(head);
        head = sol24.partitionList(head, 5);
        sol24.printList(head);
    }

    // move nodes with values greater or equal than k to the tail
    public ListNode partitionList(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        ListNode fakeHeader = new ListNode(0);
        fakeHeader.next = head;
        ListNode pre = fakeHeader;
        ListNode cur = head;
        ListNode newTail = tail;
        while (cur != tail) {
            if (cur.val < k) {
                pre = cur;
                cur = cur.next;
            } else {
                // move to tail
                pre.next = cur.next;
                newTail.next = cur;
                newTail = newTail.next;
                newTail.next = null;
                cur = pre.next;
            }
        }
        return fakeHeader.next;
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
