/**
 * Created by Hao on 9/17/15.
 */
public class Solution11 {

    public static void main(String[] args) {
        Solution11 sol11 = new Solution11();
        String str = "asdfghjytr6543./";
        boolean result = sol11.isUnique(str);
        System.out.println(result);
    }

    // assume characters in the string are within ASCII
    public boolean isUnique(String str) {
        boolean[] existed = new boolean[128];
        for (int pos = 0; pos < str.length(); ++pos) {
            int ascii = (int) str.charAt(pos);
            if (existed[ascii]) {
                return false;
            }
            existed[ascii] = true;
        }
        return true;
    }

    /* Other approaches:
     * 1. brute-force search, running time O(n^2), space O(1);
     * 2. use bitmap to further compress extra space needed;
     * 3. if the characters are not within ASCII, then we should use hashset.
     */
}
