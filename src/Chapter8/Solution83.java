package Chapter8;

/**
 * Created by Hao on 10/6/15.
 */
public class Solution83 {

    public static void main(String[] args) {
        int[] nums = {-3, -1, 0, 3, 5, 6, 8};
        int magicIndex = findMagicIndex(nums);
        System.out.println(magicIndex);
        int[] numsDup = {-3, -1, 2, 2, 5, 6, 6};
        int magicIndexDup = findMagicIndexDup(numsDup);
        System.out.println(magicIndexDup);
    }

    // binary search
    public static int findMagicIndex(final int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                return mid;
            } else if (nums[mid] < mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // follow up: duplicates in the array
    public static int findMagicIndexDup(final int[] nums) {
        return findMagicIndexDup(nums, 0, nums.length);
    }

    private static int findMagicIndexDup(final int[] nums, final int start, final int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (mid == nums[mid]) {
            return mid;
        } else if (mid > nums[mid]) {
            // find left part
            int found = findMagicIndexDup(nums, start, nums[mid]);
            if (found != -1) {
                return found;
            }
            return findMagicIndexDup(nums, mid + 1, end);
        } else {
            // find right part
            int found = findMagicIndexDup(nums, nums[mid], end);
            if (found != -1) {
                return found;
            }
            return findMagicIndexDup(nums, start, mid - 1);
        }
    }
}
