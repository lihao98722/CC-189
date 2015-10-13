package Others;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * Created by Hao on 10/12/15.
 */
public class Coins {

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        int[] A = new int[split.length];
        for(int i=0; i<split.length; i++) {
            A[i] = Integer.parseInt(split[i]);
        }
        int N = Integer.parseInt(in.nextLine().trim());
        int[] T = new int[N];
        for(int i=0; i<N; i++) {
            T[i] = Integer.parseInt(in.nextLine().trim());
        }
        long[] possibleCoins = getPossibleCoins(A, T);
        for(long c : possibleCoins)
            System.out.println(c);
        in.close();
    }

    public static long[] getPossibleCoins(int[] coins, int[] targets) {
        int maxTarget = 0;
        for (int target : targets) {
            maxTarget = maxTarget < target ? target : maxTarget;
        }
        long[] dp = new long[maxTarget + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int pos = coin; pos <= maxTarget; ++pos) {
                dp[pos] += dp[pos - coin];
                dp[pos] %= 1E9 + 7;
            }
        }
        long[] results = new long[targets.length];
        for (int pos = 0; pos < targets.length; ++pos) {
            results[pos] = dp[targets[pos]];
        }
        return results;
    }
}
