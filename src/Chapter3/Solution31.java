package Chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hao on 9/18/15.
 */
public class Solution31 {

    public static void main(String[] args) {
        ArrayStacks<Integer> arrayStacks = new ArrayStacks<>();
        for (int num = 1; num < 20; ++num) {
            if (num % 3 == 0) {
                arrayStacks.push(3, num);
            } else if (num % 2 == 0) {
                arrayStacks.push(2, num);
            } else {
                arrayStacks.push(1, num);
            }
        }
        arrayStacks.print();
        arrayStacks.pop(3);
        arrayStacks.pop(1);
        arrayStacks.pop(1);
        arrayStacks.pop(2);
        System.out.println("After poping: ");
        arrayStacks.print();
    }

    // use two pointers to divide array into three segments
    public static class ArrayStacks<T> {
        public ArrayStacks() {
            stks = new ArrayList<>();
            stkPos1 = 0;
            stkPos2 = 0;
        }

        // push element to one of the three stacks
        public void push(int stkNum, T item) {
            if (stkNum == 1) {
                stks.add(stkPos1, item);
                ++stkPos1;
                ++stkPos2;
            } else if (stkNum == 2) {
                stks.add(stkPos2, item);
                ++stkPos2;
            } else {  // for stkNum 3
                stks.add(item);
            }
        }

        // pop one of the three stacks
        public T pop(int stkNum) {
            T item;
            if (stkNum == 1) {
                item = stks.remove(stkPos1 - 1);
                --stkPos1;
                --stkPos2;
            } else if (stkNum == 2) {
                item = stks.remove(stkPos2 - 1);
                --stkPos2;
            } else {
                item = stks.remove(stks.size() - 1);
            }
            return item;
        }

        public void print() {
            int pos = 0;
            System.out.print("Stack 1: ");
            while (pos < stkPos1) {
                System.out.print(stks.get(pos) + " ");
                ++pos;
            }
            System.out.println();
            System.out.print("Stack 2: ");
            while (pos < stkPos2) {
                System.out.print(stks.get(pos) + " ");
                ++pos;
            }
            System.out.println();
            System.out.print("Stack 3: ");
            while (pos < stks.size()) {
                System.out.print(stks.get(pos) + " ");
                ++pos;
            }
            System.out.println();
        }

        private int stkPos1;
        private int stkPos2;
        private List<T> stks;
    }
}
