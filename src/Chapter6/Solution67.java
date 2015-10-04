package Chapter6;


import java.util.Random;

/**
 * Created by Hao on 10/3/15.
 */
public class Solution67 {

    public static void main(String[] args) {
        int families = 1000000;
        int boys = 0;
        int girls = families;  // each family has exact one girl.
        for (int num = 0; num < families; ++num) {
            boys += getNumOfBoysInAFamily();
        }
        double ratio = (double) girls / (double) (girls + boys);
        System.out.println(ratio);  // very close to 0.5
    }

    public static int getNumOfBoysInAFamily() {
        int boys = 0;
        Random rand = new Random();
        while (rand.nextBoolean()) {  // true means boy, false means girl
            ++boys;
        }
        return boys;
    }
}
