package Chapter8;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hao on 10/6/15.
 */
public class Solution82 {

    public static void main(String[] args) {
        // false means robots can not step on this cell.
        boolean[][] grid = {
                {true, true, true,},
                {false, true, false},
                {false, true, true}};
        List<Pair<Integer, Integer>> path = new ArrayList<>();
        if (findPath(grid, 0, 0, path)) {
            printPath(path);
        } else {
            System.out.println("No Found!");
        }
    }

    public static boolean findPath(final boolean[][] grid, final int row, final int col,
                                   List<Pair<Integer, Integer>> path) {
        if (row >= grid.length || col >= grid[0].length || grid[row][col] == false) {
            return false;
        }
        path.add(new Pair<>(row, col));
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return true;
        }
        if (findPath(grid, row, col + 1, path) || findPath(grid, row + 1, col, path)) {
            return true;
        } else {
            path.remove(path.size() - 1);
            return false;
        }
    }

    public static void printPath(final List<Pair<Integer, Integer>> path) {
        System.out.println("Path:");
        for (Pair<Integer, Integer> cell : path) {
            String s = "<" + cell.getKey() + ", " + cell.getValue() + ">";
            System.out.println(s + " ");
        }
    }
}
