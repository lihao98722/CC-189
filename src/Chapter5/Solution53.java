package Chapter5;

/**
 * Created by Hao on 10/2/15.
 */
public class Solution53 {

    public static void main(String[] args) {
        int len = getLongestOneSequence(1775);
        System.out.println(len);
    }

    public static int getLongestOneSequence(final int num) {
        int maxLen = 0;
        int count = 0;
        int curLen = 0;
        boolean flip = false;
        for (int shift = 31; shift >= 0; --shift) {
            int bit = (num >>> shift) & 1;
            if (bit == 1) {
                ++curLen;
                ++count;
                maxLen = maxLen > count ? maxLen : count;
            } else {
                if (!flip) {
                    // count should be curLen + 1, because if this 0 is the end of previous possible sequence,
                    // count would be set to 0 in last iteration.
                    count = curLen + 1;
                    maxLen = maxLen > count ? maxLen : count;
                    flip = true;
                    curLen = 0;
                } else {
                    count = 0;
                    flip = false;
                    ++shift;  // reach the end, reconsider for other possible sequences
                }
            }
        }
        return maxLen;
    }
}
