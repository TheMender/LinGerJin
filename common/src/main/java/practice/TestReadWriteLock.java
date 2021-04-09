package practice;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Title:
 * Desc:共享锁和排它锁
 *
 * @author: linyongchao
 * Date: 2021/4/91:24 PM
 */
public class TestReadWriteLock {
    static Lock lock = new ReentrantLock();
    static int value;
    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    public static void read(Lock lock) {
        try {
            lock.lock();
            TimeUnit.SECONDS.sleep(1);
            System.out.println("read order!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public static void write(Lock lock, int v) {

        try {
            lock.lock();
            value = v;
            TimeUnit.SECONDS.sleep(1);
            System.out.println("write order!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
//        Runnable read = () -> read(lock);
        Runnable read = () -> read(readLock);

//        Runnable write = () -> write(lock, new Random().nextInt());
        Runnable write = () -> write(writeLock, new Random().nextInt());

        for (int i = 0; i < 18; i++) {
            new Thread(read).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(write).start();
        }
//        String name = "测试";
//        Optional<String> opt = Optional.ofNullable(name);
//
//        System.out.println(opt.orElse("test"));

    }

}
