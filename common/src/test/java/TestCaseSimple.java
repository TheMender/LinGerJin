import org.junit.Test;

import java.math.BigDecimal;
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
}
