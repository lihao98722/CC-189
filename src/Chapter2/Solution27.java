package Chapter2;

/**
 * Created by Hao on 9/18/15.
 */
public class Solution27 {

    public static void main(String[] args) {
        Solution27 sol27 = new Solution27();
        int[] values1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ListNode head1 = sol27.createList(values1);
        int[] values2 = {100};
        ListNode head2 = sol27.createList(values2);
        head2.next = sol27.getKthNode(head1, 5);  // make an intersection
        System.out.print("List1: ");
        sol27.printList(head1);
        System.out.print("List2: ");
        sol27.printList(head2);
        ListNode pt = sol27.getIntersection(head1, head2);
        if (pt != null) {
            System.out.println("Intersected on " + pt.val);
        } else {
            System.out.println("No intersection!");
        }

    }

    public ListNode getIntersection(ListNode head1, ListNode head2) {
        int len1 = 0;
        for (ListNode p = head1; p != null; p = p.next, ++len1);
        int len2 = 0;
        for (ListNode p = head2; p != null; p = p.next, ++len2);
        // align two lists by forwarding the longer one.
        if (len1 >= len2) {
            for (int step = 0; step < len1 - len2; ++step, head1 = head1.next);
        } else {
            for (int step = 0; step < len2 - len1; ++step, head2 = head2.next);
        }
        while (head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
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
