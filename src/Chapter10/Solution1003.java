package Chapter10;

/**
 * Created by Hao on 9/24/15.
 */
public class Solution1003 {

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 6, 0, 1, 2};
        System.out.println(search(nums, 0));
        System.out.println(search(nums, 4));
    }

    // binary search
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {  // should be <=
            int mid = left + (right - left) / 2;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num < target) {
                // check if this part has been rotated
                if (target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {  // for num > target
                // check if this part has been rotated
                if (nums[left] > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;  // no found
    }

}
