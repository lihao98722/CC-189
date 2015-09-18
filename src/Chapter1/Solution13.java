/**
 * Created by Hao on 9/17/15.
 */
public class Solution13 {

    public static void main(String[] args) {
        Solution13 sol13 = new Solution13();
        String str = "aa  bb c d        ";
        char[] chars = str.toCharArray();
        int length = 10;
        sol13.URLify(chars, length);
        System.out.println(chars);
    }

    public void URLify(char[] chars, int length) {
        int pos = 0;
        int end_pos = length - 1;
        while (pos < end_pos) {
            if (chars[pos] != ' ') {
                ++pos;
            } else {
                shiftRight(chars, pos + 1, end_pos, 2);
                chars[pos] = '%';
                chars[pos + 1] = '2';
                chars[pos + 2] = '0';
                pos += 3;
                end_pos += 2;
            }
        }
    }

    // shift [start_pos, end_pos] to right by steps.
    private void shiftRight(char[] chars, int start_pos, int end_pos, int steps) {
        for (int pos = end_pos; pos >= start_pos; --pos) {
            chars[pos + steps] = chars[pos];
        }
    }
}
