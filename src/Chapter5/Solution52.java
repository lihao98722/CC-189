package Chapter5;

/**
 * Created by Hao on 10/2/15.
 */
public class Solution52 {

    public static void main(String[] args) {
        double num = 0.875;
        String binaryString = getBinaryString(num);
        System.out.println(binaryString);
    }

    public static String getBinaryString(double num) {
        if (num <= 0 || num >= 1) {
            return "ERROR";
        }
        StringBuilder bianrySB = new StringBuilder();
        bianrySB.append("0.");
        while (num > 0) {
            if (bianrySB.length() > 32) {
                return "ERROR";
            }
            if (num * 2 >= 1) {
                bianrySB.append("1");
                num = num * 2 - 1;
            } else {
                bianrySB.append("0");
                num = num * 2;
            }
        }
        return bianrySB.toString();
    }
}
