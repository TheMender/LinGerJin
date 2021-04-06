package practice;

/**
 * Title:
 * Desc:同步方法和非同步方法是否可以同时调用？
 *
 * @author: linyongchao
 * Date: 2021/4/61:32 PM
 */
public class TwoThread {

    public synchronized void m1() {
        System.out.println("m1 start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1 end");
    }

    public void m2() {
        System.out.println("m2 start");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2 end");
    }

    public static void main(String[] args) {
        TwoThread twoThread = new TwoThread();
//        new Thread(() -> twoThread.m1(), "m1").start();
//        new Thread(() -> twoThread.m2(), "m2").start();
        new Thread(twoThread::m1, "m1").start();
        new Thread(twoThread::m2, "m2").start();
    }
}

