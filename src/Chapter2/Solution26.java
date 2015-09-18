package Chapter2;

/**
 * Created by Hao on 9/18/15.
 */
public class Solution26 {

    public static void main(String[] args) {
        Solution26 sol26 = new Solution26();
        int[] values = {2, 1, 2, 2, 5, 2, 2, 1, 2};
        ListNode head = sol26.createList(values);
        System.out.print("before: ");
        sol26.printList(head);
        boolean result = sol26.isPalindrome(head);
        System.out.print("after: ");
        sol26.printList(head);
        System.out.println(result);
    }

    // reverse last half, check palindrome, then reverse back.
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        for (ListNode p = head; p != null; p = p.next) {
            ++len;
        }
        ListNode halfTail = head;
        for (int step = 0; step < (len-1) / 2; ++step) {
            halfTail = halfTail.next;
        }
        ListNode lastHalfHead = halfTail.next;
        halfTail.next = null;
        ListNode reversedLastHalf = reverseList(lastHalfHead);
        boolean result = true;
        for (ListNode p1 = head, p2 = reversedLastHalf; p1 != null && p2 != null; p1 = p1.next, p2 = p2.next) {
            if (p1.val != p2.val) {
                result = false;
                break;
            }
        }
        // restore the linked list
        halfTail.next = reverseList(reversedLastHalf);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }
        return pre;
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
