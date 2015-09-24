package Chapter10;

import java.util.Arrays;

/**
 * Created by Hao on 9/24/15.
 */
public class Solution1001 {

    public static void main(String[] args) {
        int[] A = {2, 3, 5, 0, 0};
        // endA is the valid end index of Array A
        int endA = 2;
        int[] B = {1, 4};
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));
        mergeSortedArrays(A, endA, B);
        System.out.println(Arrays.toString(A));

    }

    public static void mergeSortedArrays(int[] A, int endA, int[] B) {
        int posA = 0;
        int posB = 0;
        while (posA <= endA && posB < B.length) {
            if (A[posA] < B[posB]) {
                ++posA;
            } else {
                shiftRight(A, posA, endA, 1);
                A[posA] = B[posB];
                ++posA;
                ++posB;
                ++endA;
            }
        }
    }

    // shift the array to right by steps
    private static void shiftRight(int[] A, int start, int end, int steps) {
        for (int pos = end; pos >= start; --pos) {
            A[pos + steps] = A[pos];
        }
    }
}
