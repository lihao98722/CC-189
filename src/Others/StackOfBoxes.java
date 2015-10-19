package Others;

import java.util.Arrays;
import java.util.Comparator;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by Hao on 10/13/15.
 */
public class StackOfBoxes {

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine().trim());
        int[][] boxes = new int[N][3];
        for (int i = 0; i < N; i++) {
            String[] split = in.nextLine().split(" ");
            for (int j = 0; j < split.length; j++) {
                boxes[i][j] = Integer.parseInt(split[j]);
            }
        }
        System.out.println(highestStack(boxes));
        in.close();
    }

    static long highestStack(int[][] boxes) {

        Arrays.sort(boxes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        long[] dp = new long[boxes.length];
        for (int pos = 0; pos < boxes.length; ++pos) {
            dp[pos] = boxes[pos][2];
            long max = 0;
            for (int i = 0; i < pos; ++i) {
                if (boxes[i][0] < boxes[pos][0] && boxes[i][1] < boxes[pos][1]) {
                    max = max > dp[i] ? max : dp[i];
                }
            }
            dp[pos] += max;
        }
        long result = 0;
        for (long height : dp) {
            result = result > height ? result : height;
        }
        return result;
    }
}
