package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * Title:
 * Desc:
 *
 * <p>
 *
 * @author: linyongchao
 * Date: 2021/4/711:36 AM
 */
public class CountTest {
    static volatile long count1 = 0L;

    static AtomicInteger count2 = new AtomicInteger(0);
    static LongAdder count3 = new LongAdder();

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        Object lock=new Object();
        for (int i = 0; i < 1000; i++) {
            threads.add(new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    synchronized (lock) {
                        count1++;
                    }
                }
            }, "thread-" + i));
        }
        long start1 = System.currentTimeMillis();
        threads.forEach(o -> o.start());

        threads.forEach(o -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        long end1 = System.currentTimeMillis();

        System.out.print("long count1   ");
        System.out.println(end1 - start1);

        List<Thread> threads2 = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            threads2.add(new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    count2.incrementAndGet();
                }
            }, "thread-" + i));
        }
        long start2 = System.currentTimeMillis();
        threads2.forEach(o -> o.start());

        threads2.forEach(o -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        long end2 = System.currentTimeMillis();

        System.out.print("AtomicInteger count2   ");
        System.out.println(end2 - start2);

        List<Thread> threads3 = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            threads3.add(new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    count3.increment();
                }
            }, "thread-" + i));
        }
        long start3 = System.currentTimeMillis();
        threads3.forEach(o -> o.start());

        threads3.forEach(o -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        long end3 = System.currentTimeMillis();

        System.out.print("LongAdder count3   ");
        System.out.println(end3 - start3);
    }
}
