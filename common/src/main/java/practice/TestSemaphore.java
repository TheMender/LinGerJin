package practice;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Title:
 * Desc:信号灯，限流、车道与收费站
 *
 * @author: linyongchao
 * Date: 2021/4/97:07 PM
 */
public class TestSemaphore {
    public static void main(String[] args) {
//        Semaphore semaphore = new Semaphore(2);
        Semaphore semaphore = new Semaphore(2, true);

        new Thread(() -> {
            try {
                semaphore.acquire();//获得锁
                System.out.println("T1 running 1...");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("T1 running 2...");
                semaphore.release();
                TimeUnit.SECONDS.sleep(2);
                System.out.println("T1 running 3...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("T2 running 1...");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("T2 running 2...");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("T3 running 1...");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("T3 running 2...");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
