package Chapter5;

/**
 * Created by Hao on 10/2/15.
 */
public class Solution54 {

    public static void main(String[] args) {
        int[] nums = {1, 5, 7, 8, 10, 0x7fffffff};
        for (int num : nums) {
            System.out.println(num + ": " + getPrev(num) + " " + getNext(num));
        }
    }

    // since 0 will never be the previous or next of a positive number, thus can be used to represent "No found".

    // get previous number
    public static int getPrev(int num) {
        int rightmostZero = 0;
        while (rightmostZero < 31 && ((num >> rightmostZero) & 1) == 1) {
            ++rightmostZero;
        }
        int flipPos = rightmostZero + 1;
        while (flipPos < 31 && ((num >> flipPos) & 1) == 0) {
            ++flipPos;
        }
        // prev is negative number
        if (flipPos >= 31) {
            int rightmostOne = 0;
            while (rightmostOne <= 31 && ((num >> rightmostOne) & 1) == 0) {
                ++rightmostOne;
            }
            return num + (1 << 31) - (1 << rightmostOne);
        } else {
            return num - (1 << flipPos) + (1 << (flipPos - 1));
        }
    }

    // get next number
    public static int getNext(int num) {
        int rightmostOne = 0;
        while (rightmostOne <= 31 && ((num >> rightmostOne) & 1) == 0) {
            ++rightmostOne;
        }
        int flipPos = rightmostOne + 1;
        while (flipPos < 31 && ((num >> flipPos) & 1) == 1) {
            ++flipPos;
        }
        // no next exists
        if (rightmostOne > 31 || flipPos >= 31) {
            return 0;
        } else {
            return num - (1 << (flipPos - 1)) + (1 << flipPos);
        }
    }
}
