package Chapter10;

import java.util.Arrays;

/**
 * Created by Hao on 9/24/15.
 */
public class Solution1011 {

    public static void main(String[] args) {
        int[] nums = {5, 5, 3, 1, 2, 3, 4, 7};
        sortPeeksAndValleys(nums);
        System.out.println(Arrays.toString(nums));
    }

    // swap with the next one to satisfy its property
    public static void sortPeeksAndValleys(int[] nums) {
        boolean peak = true;
        for (int pos = 0; pos < nums.length - 1; ++pos) {
            if (peak) {
                if (nums[pos] < nums[pos + 1]) {
                    int temp = nums[pos];
                    nums[pos] = nums[pos + 1];
                    nums[pos + 1] = temp;
                }
            } else {
                if (nums[pos] > nums[pos + 1]) {
                    int temp = nums[pos];
                    nums[pos] = nums[pos + 1];
                    nums[pos + 1] = temp;
                }
            }
            peak = !peak;
        }
    }
}
