import org.junit.Test;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Title:
 * Desc:
 */
public class TestCaseSimple {

    @Test
    public void test() {
        int num = 2147483647;
        num += 1;
        System.out.println(num);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    @Test
    public void testd() {
        int line = 6;
        for (int i = 1; i < line; i++) {
            for (int j = 1; j < line - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    @Test
    public void testc() {
        String str = "i"+"3333"+"20201214142030"+md5LowerCase32("f6rmpy2y59tqu7mptv94jg5vx5r6ll33");
        System.out.println(md5LowerCase32(str));
    }

    public static String md5LowerCase32(String str) {
        String restr = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int bt = b & 0xff;
                if (bt < 16)
                    stringBuffer.append(0);
                stringBuffer.append(Integer.toHexString(bt));
            }
            restr = stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restr;
    }
}
