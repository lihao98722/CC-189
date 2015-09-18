/**
 * Created by Hao on 9/17/15.
 */
import java.util.HashMap;
import java.util.Map;

public class Solution12 {

    public static void main(String[] args) {
        Solution12 sol12 = new Solution12();
        String str1 = "abcddef";
        String str2 = "feddcba";
        boolean result = sol12.checkPermutation(str1, str2);
        System.out.println(result);
    }

    // all permutations of a string have the exactly same characters.
    public boolean checkPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        Map<Character, Integer> hmap = new HashMap<Character, Integer>();
        for (int pos = 0; pos < str1.length(); ++pos) {
            char ch = str1.charAt(pos);
            if (!hmap.containsKey(ch)) {
                hmap.put(ch, 1);
            } else {
                hmap.put(ch, hmap.get(ch) + 1);
            }
        }
        for (int pos = 0; pos < str2.length(); ++pos) {
            char ch = str2.charAt(pos);
            if (!hmap.containsKey(ch)) {
                return false;
            } else {
                hmap.put(ch, hmap.get(ch) - 1);
                if (hmap.get(ch) == 0) {
                    hmap.remove(ch);
                }
            }
        }
        return hmap.isEmpty();
    }
}
