package Others;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by Hao on 10/12/15.
 */
public class Routing {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        int[] A = new int[split.length];
        for(int i=0; i<split.length; i++)
            A[i] = Integer.parseInt(split[i]);
        int row = A[0];
        int col = A[1];
        char[][] grid = new char[row][];
        for (int i = 0; i < row; ++i) {
            String rowStr = in.nextLine();
            grid[i] = rowStr.toCharArray();
        }
        in.close();
        long[] result = getRoutes(grid);
        for (long n : result) {
            System.out.println(n);
        }
    }

    public static long[] getRoutes(char[][] grid) {
        long[] result = new long[2];
        result[0] = 0;
        result[1] = -1;
        if (grid[0][0] == 'x') {
            return result;
        }
        int rowLen = grid.length;
        int colLen = grid[0].length;
        long[][] dp = new long[rowLen][];
        for (int pos = 0; pos < dp.length; ++pos) {
            dp[pos] = new long[colLen];
        }
        boolean[][] visited = new boolean[rowLen][];
        for (int pos = 0; pos < visited.length; ++pos) {
            visited[pos] = new boolean[colLen];
        }
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0 * colLen + 0);
        dp[0][0] = 1;
        long len = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Set<Integer> level = new HashSet<>();
            for (int n = 0; n < levelSize; ++n) {
                int point = queue.removeFirst();
                int row = point / colLen;
                int col = point % colLen;
                visited[row][col] = true;
                if (row == rowLen - 1 && col == colLen - 1) {
                    result[0] = dp[row][col];
                    result[1] = len;
                    return result;
                }
                updateRoute(grid, row + 1, col, dp, visited, level, dp[row][col]);
                updateRoute(grid, row, col + 1, dp, visited, level, dp[row][col]);
                updateRoute(grid, row - 1, col, dp, visited, level, dp[row][col]);
                updateRoute(grid, row, col - 1, dp, visited, level, dp[row][col]);
            }
            for (Integer p : level) {
                queue.add(p);
            }
            ++len;
        }
        return result;
    }

    public static void updateRoute(char[][] grid, int row, int col, long[][] dp, boolean[][] visited,
                                   Set<Integer> level, long routes) {
        int colLen = grid[0].length;
        if (row < 0 || row >= grid.length || col < 0 || col >= colLen) {
            return;
        }
        if (!visited[row][col] && grid[row][col] != 'x') {
            level.add(row * colLen + col);
            dp[row][col] += routes;
            dp[row][col] %= 1E9 + 7;
        }
    }
}
