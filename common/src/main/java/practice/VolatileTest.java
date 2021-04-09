package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * Title:
 * Desc:
 * volatile并不能保证多个线程共同修改running变量所带来的不一致问题，也就是volatile并不能代替synchronized
 * <p>
 * AtomXXX类本身方法都是原子性的，但不不能保证多个方法连续调用还是原子性的
 *
 * @author: linyongchao
 * Date: 2021/4/711:36 AM
 */
public class VolatileTest {
//    volatile int count = 0;

    AtomicInteger count = new AtomicInteger(0);
    void sum() {
//        synchronized (VolatileTest.class) {
        for (int j = 0; j < 1000; j++) {
//            synchronized (this) {
//                count++;
                count.incrementAndGet();
//            }
        }
    }

    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
//            new Thread(volatileTest::sum).start();
            threads.add(new Thread(volatileTest::sum, "thread-" + i));
        }
        threads.forEach(o -> o.start());

        threads.forEach(o -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(volatileTest.count);
    }
}
