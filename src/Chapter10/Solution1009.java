package Chapter10;

import javafx.util.Pair;

/**
 * Created by Hao on 9/24/15.
 */
public class Solution1009 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {6, 7, 9}, {12, 15, 18}};
        int target = 7;
        Pair<Integer, Integer> pos = findMatrix(matrix, target);
        System.out.println(pos.getKey() + ", " + pos.getValue());
    }

    // binary search to find target, return its position as pair.
    public static Pair<Integer, Integer> findMatrix(int[][] matrix, int target) {
        // binary search to find row
        int upRow = 0;
        int downRow = matrix.length - 1;
        int midRow = 0;
        while (upRow <= downRow) {
            midRow = upRow + (downRow - upRow) / 2;
            int num = matrix[midRow][0];
            if (num == target) {
                break;
            } else if (num < target) {
                // get range
                if (matrix[midRow + 1][0] > target) {
                    break;
                }
                upRow = midRow + 1;
            } else {
                downRow = midRow - 1;
            }
        }
        // binary search to find column
        int left = 0;
        int right = matrix[midRow].length - 1;
        int midCol = 0;
        while (left <= right) {
            midCol = left + (right - left) / 2;
            int num = matrix[midRow][midCol];
            if (num == target) {
                break;
            }
            if (num < target) {
                left = midCol + 1;
            } else {
                right = midCol - 1;
            }
        }
        // no found, return (-1, -1)
        if (left > right) {
            return new Pair<>(-1, -1);
        }
        return new Pair<>(midRow, midCol);
    }
}
