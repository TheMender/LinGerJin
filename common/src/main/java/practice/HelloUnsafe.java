package practice;

import sun.misc.Unsafe;

/**
 * Title:
 * Desc:
 *
 * @author: linyongchao
 * Date: 2021/4/71:52 PM
 */
public class HelloUnsafe {
    static class M {
        int i = 0;
    }

    public static void main(String[] args) {
        //Unsafe 类非底层加载器加载过来的类禁止初始化
        Unsafe unsafe = Unsafe.getUnsafe();
        try {
            M m = (M) unsafe.allocateInstance(M.class);
            m.i = 9;
            System.out.println(m.i);
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

}
