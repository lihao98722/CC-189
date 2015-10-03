package Chapter5;

/**
 * Created by Hao on 10/2/15.
 */
public class Solution58 {

    public static void main(String[] args) {
        byte[] screen = {(byte) 0xa1, (byte) 0xb2, (byte) 0xc3, (byte) 0xd4, (byte) 0xe5, (byte) 0xf6};
        int width = 16;
        int x1 = 2;
        int x2 = 13;
        int y = 1;
        printBinary(screen, width);
        drawLine(screen, width, x1, x2, y);
        System.out.println();
        printBinary(screen, width);
    }

    public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
        int start = width * y + x1;
        int end = width * y + x2;
        int startOffset = start % 8;
        int endOffset = end % 8;
        byte startMask = (byte) (0xff >>> startOffset);
        byte endMask = (byte) ~(0xff >>> endOffset);
        // x1 and x2 are in the same byte
        if ((start / 8) == (end / 8)) {
            byte mask = (byte) (startMask & endMask);
            screen[start / 8] |= mask;
        } else {
            // deal with startByte and endByte
            screen[start / 8] |= startMask;
            screen[end / 8] |= endMask;
            // deal with middle bytes
            for (int pos = start / 8 + 1; pos <= end / 8 - 1; ++pos) {
                screen[pos] = (byte) (0xff);
            }
        }
    }

    private static void printBinary(byte[] bytes, int width) {
        for (int pos = 0; pos < bytes.length; ++pos) {
            byte b = bytes[pos];
            for (int shift = 7; shift >= 0; --shift) {
                int bit = (b >>> shift) & 1;
                System.out.print(bit);
            }
            if (pos % (width / 8) == 1) {
                System.out.println();
            }
        }
    }
}
