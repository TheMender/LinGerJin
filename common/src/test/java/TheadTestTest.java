//import org.junit.Test;
//
///**
// * Title:
// * Desc:
// *
// * @author: linyongchao
// * Date: 2021/3/177:35 PM
// */
//public class TheadTestTest {
//
//    @Test
//    public void testd() {
////        TheadTest theadTest = new TheadTest();
////        theadTest.run();
////        ClassLayout layout= ClassLayout.parseInstance(new Object());
////        System.out.println(layout.toPrintable());
//        String str = "absba";
//        System.out.println(judge(str));
//    }
//
//    public boolean judge(String str) {
//        // write code here
//        if (str.length() > 1) {
//            if (str.length() == 2) {
//                if (str.charAt(0) == str.charAt(str.length())) {
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//            if (str.charAt(0) == str.charAt(str.length()-1)) {
//                return judge(str.substring(1, str.length() - 1));
//            } else {
//                return false;
//            }
//        } else {
//            return true;
//        }
//    }
//}