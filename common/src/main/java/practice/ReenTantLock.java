package practice;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Title:ReentrantLock可以代替synchronized
 * Desc:
 * synchronized的锁遇到异常，jvm会自动释放锁，ReentrantLock必须手动释放锁
 * synchronized为非公平锁，ReentrantLock可以选择是否为公平锁
 *
 * @author: linyongchao
 * Date: 2021/4/812:19 PM
 */
public class ReenTantLock {
    Lock lock = new ReentrantLock();

    /*synchronized*/ void m1() {
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            lock.unlock();
        }
    }

    /*synchronized*/ void m2() {
        boolean locked = false;
        try {
            locked = lock.tryLock(5, TimeUnit.SECONDS);
            lock.lockInterruptibly();//可以对interrupt()方法做出响应
            System.out.println("m2 jion......" + locked);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if (locked)
                lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReenTantLock t = new ReenTantLock();
        new Thread(() -> t.m1()).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        new Thread(() -> t.m2()).start();
        Thread t3 = new Thread(() -> t.m2());
        t3.interrupt();//打断线程等待
    }
}
