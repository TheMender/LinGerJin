package practice;

/**
 * Title:
 * Desc:
 *
 * @author: linyongchao
 * Date: 2021/4/611:09 AM
 */
public class SynThread {

    private static int count = 10;
    private Object o = new Object();

    public void mrun() {
        synchronized (o) {
            count--;
            System.out.println(Thread.currentThread().getName() + "count = " + count);
        }
    }

    public synchronized static void m() { //这里等同于synchronized(SynThread.class)
        count--;
        System.out.println(Thread.currentThread().getName() + "count = " + count);
    }
}
