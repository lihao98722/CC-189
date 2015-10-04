package Chapter6;

import java.util.Random;

/**
 * Created by Hao on 10/3/15.
 */
public class Solution610 {

    public static void main(String[] args) {
        int result = getPoisonedBottle();
        System.out.println("Found: " + result);
    }

    public static int getPoisonedBottle() {
        boolean[] strips = new boolean[10];
        int total = 1000;
        // generate a random poisoned bottle
        Random rand = new Random();
        int poison = rand.nextInt(1000) + 1;
        System.out.println("poisoned bottle: " + poison);
        for (int num = 1; num <= total; ++num) {
            if (num == poison) {
                // set corresponding strips to positive
                for (int pos = 0; pos < 10; ++pos) {
                    if (((num >>> pos) & 1) == 1) {
                        strips[9 - pos] = true;
                    }
                }
            }
        }
        int result = 0;
        for (int pos = 0; pos < strips.length; ++pos) {
            result = (result << 1) + (strips[pos] ? 1 : 0);
        }
        return result;
    }
}
