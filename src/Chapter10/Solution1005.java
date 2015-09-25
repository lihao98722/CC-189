package Chapter10;

/**
 * Created by Hao on 9/24/15.
 */
public class Solution1005 {

    public static void main(String[] args) {
        String[] strs = {"a", "", "ba", "bb", "cb", "", "", "d"};
        String target = "ba";
        int pos = findString(strs, target);
        System.out.println(pos);
    }

    // binary search
    public static int findString(String[] strs, String target) {
        int left = 0;
        int right = strs.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            String str = strs[mid];
            // deal with empty string
            if ("".equals(str)) {
                int leftStringPos = leftNonEmptyString(strs, left, mid - 1);
                int rightStringPos = rightNonEmptyString(strs, mid + 1, right);
                if (leftStringPos != -1) {
                    if (target.compareTo(strs[leftStringPos]) <= 0) {
                        right = leftStringPos;
                        continue;
                    }
                }
                if (rightStringPos != -1) {
                    if (target.compareTo(strs[rightStringPos]) >= 0) {
                        left = rightStringPos;
                        continue;
                    }
                }
                // both left and right sides are all empty string
                return -1;
            } else if (str.equals(target)) {
                return mid;
            } else if (str.compareTo(target) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // find the first non-empty string on left side
    private static int leftNonEmptyString(String[] strs, int start, int end) {
        for (int pos = end; pos >= start; --pos) {
            if (!"".equals(strs[pos])) {
                return pos;
            }
        }
        return -1;
    }

    // find the first non-empty string on right side
    private static int rightNonEmptyString(String[] strs, int start, int end) {
        for (int pos = start; pos <= end; ++pos) {
            if (!"".equals(strs[pos])) {
                return pos;
            }
        }
        return -1;
    }
}
