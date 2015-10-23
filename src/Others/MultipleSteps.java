package Others;

/**
 * Created by Hao on 10/11/15.
 */
public class MultipleSteps {

    static long[] countPaths(int[] A, int[] T) {
        int maxTarget = 0;
        for (int target : T) {
            maxTarget = maxTarget > target ? maxTarget : target;
        }
        long[] dp = new long[maxTarget + 1];
        dp[0] = 1;
        for (int pos = 1; pos < dp.length; ++pos) {
            for (int step : A) {
                dp[pos] += pos >= step ? dp[pos - step] : 0;
            }
        }
        long[] results = new long[T.length];
        for (int pos = 0; pos < T.length; ++pos) {
            results[pos] = dp[T[pos]];
        }
        return results;
    }
}
