
import java.util.regex.Pattern;
import java.io.*;

/**
 * Created by Hao on 10/16/15.
 */
public class MyRegex {

    public static void main(String[] args) {
        String str = "((0?[0-9]?[0-9])|(1[0-9]{2})|(25[0-5])|(2[0-4][0-9]))";
        String ipPattern = "(" + str + "\\." + ")" + "{3}" + str;
        Pattern pattern = Pattern.compile(ipPattern);
        String ip = "1.001.033.254";
        boolean match = pattern.matcher(ip).matches();
        System.out.println(match);
    }
}
