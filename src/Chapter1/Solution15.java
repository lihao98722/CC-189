import javafx.util.Pair;

/**
 * Created by Hao on 9/17/15.
 */
public class Solution15 {

    public static void main(String[] args) {
        Solution15 sol15 = new Solution15();
        Pair<String, String> pair1 = new Pair<>("pale", "ple");
        Pair<String, String> pair2 = new Pair<>("pales", "pale");
        Pair<String, String> pair3 = new Pair<>("pale", "bale");
        Pair<String, String> pair4 = new Pair<>("pale", "bake");
        System.out.println(sol15.isOneAway(pair1.getKey(), pair1.getValue()));
        System.out.println(sol15.isOneAway(pair2.getKey(), pair2.getValue()));
        System.out.println(sol15.isOneAway(pair3.getKey(), pair3.getValue()));
        System.out.println(sol15.isOneAway(pair4.getKey(), pair4.getValue()));
    }

    public boolean isOneAway(String str1, String str2) {
        if (Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }
        // if they have the same length, there must be at most one different character.
        if (str1.length() == str2.length()) {
            for (int pos = 0; pos < str1.length(); ++pos) {
                if (str1.charAt(pos) != str2.charAt(pos)) {
                     return str1.substring(pos + 1).equals(str2.substring(pos + 1));
                }
            }
            return true;
        } else if (str1.length() > str2.length()) {  // str1.lenth() == str2.length() + 1
            for (int pos = 0; pos < str2.length(); ++pos) {
                if (str1.charAt(pos) != str2.charAt(pos)) {
                    return str1.substring(pos + 1).equals(str2.substring(pos));
                }
            }
            return true;
        } else {  // str2.length() == str1.length() + 1
            for (int pos = 0; pos < str1.length(); ++pos) {
                if (str2.charAt(pos) != str1.charAt(pos)) {
                    return str2.substring(pos + 1).equals(str1.substring(pos));
                }
            }
            return true;
        }
    }
}
