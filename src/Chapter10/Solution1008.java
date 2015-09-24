package Chapter10;

import java.util.BitSet;

/**
 * Created by Hao on 9/24/15.
 */
public class Solution1008 {

    /*
     * by using bitset, the maximum extra space needed is 32000bits = 4KB, time complexity O(n);
     * other approach: sort the array to make duplicates be next to each other, time complexity O(nlogn).
     */
    public static void findDuplicates(int[] nums) {
        BitSet bitset = new BitSet(32000 + 1);
        for (int num : nums) {
            if (bitset.get(num)) {
                System.out.print(num + " ");
            } else {
                bitset.set(num);
            }
        }
    }
}
