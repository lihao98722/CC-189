package Chapter10;

import java.util.BitSet;

/**
 * Created by Hao on 9/24/15.
 */
public class Solution1007 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 5, 34, 434};
        System.out.println(getMissionInt(nums));
    }

    /* for integer, non-negative numbers ranges from 0 to 2^31 - 1,
     * so we only needs 2^31 bits = 250MB to keep track of whether they appears or not by using bitset.
     */
    // suppose extract nums from files to nums array,
    // extract part of the nums each time to make sure it does not exceed the memory limit.
    public static int getMissionInt(int[] nums) {
        BitSet bitset = new BitSet();
        for (int num : nums) {
            bitset.set(num);
        }
        // find the first missing num
        for (int num = 0; num < Integer.MAX_VALUE; ++num) {
            if (!bitset.get(num)) {
                return num;
            }
        }
        return -1;
    }

    /* Follow up:
     * 10MB of memory is not enough for entire bitset for all non-negative integers, so we need to apply
     * divide and conquer here.
     * non-negative numbers range from 0 to 2^31 - 1, can be divided into 256 segments so that each segments has
     * 2^23 numbers, which can be hold in a 8MB bitset. Then for each segment, traverse all the numbers to find the
     * first missing integer.
     */
}
