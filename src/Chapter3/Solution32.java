package Chapter3;

import java.util.Stack;

/**
 * Created by Hao on 9/18/15.
 */
public class Solution32 {

    public static void main(String[] args) {
        MinStack<Integer> minStack = new MinStack<Integer>();
        minStack.push(1);
        minStack.push(2);
        System.out.println(minStack.peek());
        System.out.println(minStack.min());
        minStack.push(-1);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.peek());
        System.out.println(minStack.min());
    }

    private static class MinStack<T extends Comparable<T>> {

        public void push(T val) {
            stk.push(val);
            if (minStk.isEmpty()) {
                minStk.push(val);
            } else {
                // if val is less than current minimal value, push it onto the minStk.
                if (val.compareTo(minStk.peek()) <= 0) {
                    minStk.push(val);
                }
            }
        }

        public T peek() {
            return stk.peek();
        }

        public void pop() {
            T val = stk.peek();
            stk.pop();
            if (val.compareTo(minStk.peek()) == 0) {
                minStk.pop();
            }
        }

        public T min() {
            return minStk.peek();
        }

        private Stack<T> stk = new Stack<>();
        private Stack<T> minStk = new Stack<>();
    }
}
