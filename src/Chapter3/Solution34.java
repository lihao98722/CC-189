package Chapter3;

import java.util.Stack;

/**
 * Created by Hao on 9/19/15.
 */

public class Solution34 {

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.add(1);
        myQueue.add(2);
        System.out.println(myQueue.element());
        myQueue.add(3);
        myQueue.remove();
        myQueue.remove();
        System.out.println(myQueue.element());
    }

    private static class MyQueue<T> {
        public boolean add(T val) {
            inStk.push(val);
            return true;
        }

        public T remove() {
            if (outStk.empty()) {
                while (!inStk.empty()) {
                    outStk.push(inStk.pop());
                }
            }
            return outStk.pop();
        }

        public T element() {
            if (outStk.empty()) {
                while (!inStk.empty()) {
                    outStk.push(inStk.pop());
                }
            }
            return outStk.peek();
        }
        private Stack<T> inStk = new Stack<>();
        private Stack<T> outStk = new Stack<>();
    }
}
