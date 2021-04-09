package practice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Title:
 * Desc:
 *
 * @author: linyongchao
 * Date: 2021/4/81:12 PM
 */
public class ReentrantLockTrue extends Thread {

    private static Lock lock = new ReentrantLock(false);//true为公平锁，false为非公平锁

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获得锁！");
            } finally {
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) {
        ReentrantLockTrue reentrantLockTrue = new ReentrantLockTrue();
        Thread t1 = new Thread(reentrantLockTrue);
        Thread t2 = new Thread(reentrantLockTrue);
        t1.start();
        t2.start();
    }
}
