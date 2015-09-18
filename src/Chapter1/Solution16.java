/**
 * Created by Hao on 9/17/15.
 */
public class Solution16 {

    public static void main(String[] args) {
        Solution16 sol16 = new Solution16();
        String str1 = "bbaaccccdeeef";
        String str2 = "abcdd";
        System.out.println(sol16.compressString(str1));
        System.out.println(sol16.compressString(str2));
    }

    public String compressString(String str) {
        String result = "";
        int count = 0;
        char curChar = '0';
        for (int pos = 0; pos < str.length(); ++pos) {
            if (count == 0) {
                curChar = str.charAt(pos);
                ++count;
                continue;
            }
            if (curChar == str.charAt(pos)) {
                ++count;
            } else {
                result += String.valueOf(curChar) + String.valueOf(count);
                count = 0;
                --pos;
            }
        }
        // deal with the last character
        if (count > 0) {
            result += String.valueOf(str.charAt(str.length() - 1)) + String.valueOf(count);
        }
        return result.length() < str.length()? result : str;
    }
}
