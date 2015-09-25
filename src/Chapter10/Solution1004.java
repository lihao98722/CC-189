package Chapter10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Hao on 9/24/15.
 */
public class Solution1004 {

    public static void main(String[] args) {
        Integer[] data = {1, 3, 4, 6, 8, 12, 23};
        Listy listy = new Listy(Arrays.asList(data));
        int pos = findSortedArrayWithoutSize(listy, 8);
        System.out.println(pos);
    }

    // binary search
    public static int findSortedArrayWithoutSize(Listy listy, int target) {
        // find range by binary expansion
        int lowerBound = 0;
        int upperBound = 1;
        while (listy.elementAt(upperBound) != -1 && listy.elementAt(upperBound) < target) {
            lowerBound = upperBound;
            upperBound *= 2;
        }
        int left = lowerBound;
        int right = upperBound;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int num = listy.elementAt(mid);
            if (num == -1) {
                right = mid - 1;
            } else if (num == target) {
                return mid;
            } else if (num < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static class Listy {
        public Listy() {
            nums = new ArrayList<>();
        }

        public Listy(List<Integer> data) {
            nums = new ArrayList<>(data);
        }

        public int elementAt(int pos) {
            if (pos < nums.size()) {
                return nums.get(pos);
            } else {
                return -1;
            }
        }

        private List<Integer> nums;
    }
}
