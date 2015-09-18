/**
 * Created by Hao on 9/18/15.
 */
public class Solution19 {

    public static void main(String[] args) {
        Solution19 sol19 = new Solution19();
        String str1 = "123456";
        String str2 = "456123";
        boolean result = sol19.isRotatedString(str1, str2);
        System.out.println(result);
    }

    // if str2 is a substring of String(str1+str1), then str2 is a rotated version of str1.
    public boolean isRotatedString(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        str1 += str1;
        return str1.contains(str2);
    }
}
