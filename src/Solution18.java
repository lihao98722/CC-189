import java.util.Arrays;

/**
 * Created by Hao on 9/18/15.
 */
public class Solution18 {

    public static void main(String[] args) {
        Solution18 sol18 = new Solution18();
        int[][] matrix = new int[][]{
                {1, 2, 0},
                {3, 4, 5},
                {6, 0, 7},
                {8, 9, 10}
        };
        sol18.setZeroMatrix(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public void setZeroMatrix(int[][] matrix) {
        int[][] temp = matrix.clone();
        for (int row = 0; row < matrix.length; ++row) {
            temp[row] = matrix[row].clone();
        }
        for (int row = 0; row < temp.length; ++row) {
            for (int col = 0; col < temp[row].length; ++col) {
                if (temp[row][col] == 0) {
                    setRowAndColumnToZero(matrix, row, col);
                }
            }
        }
    }

    private void setRowAndColumnToZero(int[][] matrix, int row, int col) {
        // set entire row to zero
        for (int c = 0; c < matrix[row].length; ++c) {
            matrix[row][c] = 0;
        }
        // set entire column to zero
        for (int r = 0; r < matrix.length; ++r) {
            matrix[r][col] = 0;
        }
    }
}
