package Chapter2;

/**
 * Created by Hao on 9/18/15.
 */
public class Solution25 {

    public static void main(String[] args) {
        Solution25 sol25 = new Solution25();
        int[] num1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] num2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ListNode head1 = sol25.createList(num1);
        ListNode head2 = sol25.createList(num2);
        sol25.printList(head1);
        sol25.printList(head2);
        ListNode resultList = sol25.sumLists(head1, head2);
        sol25.printList(resultList);
    }

    /* Follow up: the digits are stored in a forward order
     * just reverse these two lists and add it up, then reverse the result.
     */
    public ListNode sumLists(ListNode head1, ListNode head2) {
        ListNode fakeHeader = new ListNode(0);
        ListNode cur = fakeHeader;
        int carry = 0;
        while (head1 != null && head2 != null) {
            int sum = head1.val + head2.val + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
            head1 = head1.next;
            head2 = head2.next;
        }
        while (head1 != null) {
            int sum = head1.val + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
            head1 = head1.next;
        }
        while (head2 != null) {
            int sum = head2.val + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
            head2 = head2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
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
