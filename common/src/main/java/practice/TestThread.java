package practice;

import java.util.concurrent.TimeUnit;

/**
 * Title:
 * Desc:程序中如果出现异常默认锁是会被释放的
 * 所以，在并发处理的过程中，有异常要多加小心，不然可能会发生不一致的情况
 *
 * @author: linyongchao
 * Date: 2021/4/61:56 PM
 *
 *
 * synchronized
 * Markword 记录这个线程的id 偏向锁
 * 如果线程争用：升级为 自旋锁，用户态
 * 10次以后升级为重量锁，os内核态
 * 执行时间段（加锁代码），线程数少，用自旋锁
 * 执行时间长，线程数多，用系统锁
 */
public class TestThread {
    int count = 0;

    synchronized void m() {
        System.out.println(Thread.currentThread().getName() + " start");
        while (true) {
            count++;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 5) {
                int i = 1 / 0;//此处产生异常，锁将被释放，要想不被释放，可以在catch中获得锁,然后让锁循环
                System.out.println(i);
            }
            if(count == 10){
                int i = 1 / 0;//此处产生异常，锁将被释放，要想不被释放，可以在catch中获得锁,然后让锁循环
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        TestThread t = new TestThread();
        /*Runnable runnable = new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        };*/

        new Thread(() -> t.m(), "t1").start();
        new Thread(t::m, "t2").start();
    }
}
