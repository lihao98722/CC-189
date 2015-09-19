package Chapter3;

import java.util.Stack;

/**
 * Created by Hao on 9/19/15.
 */
public class Solution35 {

    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(2);
        stk.push(3);
        stk.push(1);
        stk.push(10);
        stk = sortStack(stk);
        while (!stk.empty()) {
            System.out.println(stk.pop());
        }
    }

    // use generic to improve flexibility
    public static <T extends Comparable<T>> Stack<T> sortStack(Stack<T> stk) {
        Stack<T> orderStk = new Stack<>();
        // orderStk is always in order.
        while (!stk.empty()) {
            T val = stk.pop();
            while (!orderStk.empty() && val.compareTo(orderStk.peek()) > 0) {
                stk.push(orderStk.pop());
            }
            orderStk.push(val);
        }
        return orderStk;
    }
}
