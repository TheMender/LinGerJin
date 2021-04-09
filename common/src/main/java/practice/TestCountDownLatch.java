package practice;

import java.util.concurrent.CountDownLatch;

/**
 * Title:
 * Desc:
 *
 * @author: linyongchao
 * Date: 2021/4/81:26 PM
 */
public class TestCountDownLatch {
    private static void usingCountDownLacth() {
        Thread[] threads = new Thread[100];
        CountDownLatch countDownLatch = new CountDownLatch(threads.length);
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                int result = 0;
                for (int j = 0; j < 100; j++) {
                    result += j;
                }
                countDownLatch.countDown();
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end countDownLatch");
    }
}
