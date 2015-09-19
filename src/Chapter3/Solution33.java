package Chapter3;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Hao on 9/19/15.
 */
public class Solution33 {

    public static void main(String[] args) {
        SetOfStacks<Integer> setOfStacks = new SetOfStacks<>(3);
        for (int num = 1; num < 10; ++num) {
            setOfStacks.push(num);
        }
        for (int count = 0; count < 5; ++count) {
            System.out.println(setOfStacks.pop());
        }
    }

    // use linked list as Queue to arrange set of stacks.
    public static class SetOfStacks<T> {
        public SetOfStacks(int singleStackCapacity) {
            this.singleStackCapacity = singleStackCapacity;
            this.stkQueue = new LinkedList<>();
        }

        public void push(T item) {
            if (stkQueue.isEmpty() || stkQueue.getFirst().size() >= singleStackCapacity) {
                stkQueue.addFirst(new Stack<T>());
            }
            stkQueue.getFirst().push(item);
        }

        public T pop() {
            T item = stkQueue.getFirst().pop();
            if (stkQueue.getFirst().isEmpty()) {
                stkQueue.removeFirst();
            }
            return item;
        }

        public T peek() {
            return stkQueue.getFirst().peek();
        }

        private int singleStackCapacity;
        private LinkedList<Stack<T>> stkQueue;
    }
}
