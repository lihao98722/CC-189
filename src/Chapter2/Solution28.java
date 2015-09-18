package Chapter2;

import java.util.List;

/**
 * Created by Hao on 9/18/15.
 */
public class Solution28 {

    public static void main(String[] args) {
        Solution28 sol28 = new Solution28();
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 5};
        ListNode head = sol28.createList(values);
        sol28.printList(head);
        sol28.makeLoop(head, 5);
        ListNode loopBeginning = sol28.getLoopBeginning(head);
        System.out.println("Loop begins at: " + loopBeginning.val);
    }

    /* running time O(n), space O(1)
     * slow pointer forwards 1 step, while fast pointer forwards 2 steps each time, and they will met in certain point.
     * If slow pointer has forwarded k steps, then fast pointer has forwarded 2k steps.
     * Let the distance between head and the point that loop begins be A, length of loop be B,
     * the distance between the metPoint and loop beginning point be X, then k + X = A + mB, 2k + X = A + nB, (n > m)
     * So 2(A + mB - X) = A + nB - X, A = (n - 2m)B + X.
     * Since B is a loop, the distance between the metPoint and loop beginning point equals to
     * the distance between head and loop beginning point.
     */
    public ListNode getLoopBeginning(ListNode head) {
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode metPoint = slow;
        // forwarding until they met, the metPoint is where loop begins.
        while (head != metPoint) {
            head = head.next;
            metPoint = metPoint.next;
        }
        return metPoint;
    }

    // make a loop that begins at the kth node.
    private void makeLoop(ListNode head, int k) {
        ListNode loopBegin = head;
        for (int step = 0; step < k - 1; ++step) {
            loopBegin = loopBegin.next;
        }
        ListNode tail = head;
        for (; tail.next != null; tail = tail.next);
        tail.next = loopBegin;
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
