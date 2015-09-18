/**
 * Created by Hao on 9/17/15.
 */
import java.util.HashSet;
import java.util.Set;

public class Solution14 {

    public static void main(String[] args) {
        Solution14 sol14 = new Solution14();
        String str = "ADD   bbc a";
        boolean result = sol14.isPalindromePermutation(str);
        System.out.println(result);
    }

    // at most one character in a palindrome can have odd number of repeats.
    public boolean isPalindromePermutation(String str) {
        Set<Character> charSet = new HashSet<Character>();
        for (int pos = 0; pos < str.length(); ++pos) {
            char ch = str.charAt(pos);
            if (ch == ' ') {
                continue;
            }
            ch = Character.toLowerCase(ch);
            if (charSet.contains(ch)) {
                charSet.remove(ch);
            } else {
                charSet.add(ch);
            }
        }
        return charSet.size() <= 1;
    }
}
