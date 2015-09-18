import java.util.Arrays;

/**
 * Created by Hao on 9/18/15.
 */
public class Solution17 {

    public static void main(String[] args) {
        Solution17 sol17 = new Solution17();
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        sol17.rotateMatrix(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public void rotateMatrix(int[][] matrix) {
        // swap rows according to the central row
        for (int row = 0; row < matrix.length / 2; ++row) {
            for (int col = 0; col < matrix[row].length; ++col) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[matrix.length - row - 1][col];
                matrix[matrix.length - row - 1][col] = temp;
            }
        }
        // swap top-right triangular matrix with bottom-left triangular matrix.
        for (int row = 0; row < matrix.length; ++row) {
            for (int col = row + 1; col < matrix[row].length; ++col) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }
}
