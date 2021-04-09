package practice;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Title:线程间通信，游戏中双人交换
 * Desc:
 *
 * @author: linyongchao
 * Date: 2021/4/97:47 PM
 */
public class TestExchanger {
    static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        new Thread(() -> {
            String s = "T1";
            try {
                s = exchanger.exchange(s);//阻塞的
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);
        }, "t1").start();


        new Thread(() -> {
            String s = "T2";
            try {
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);
        }, "t2").start();

        new Thread(() -> {
            String s = "T3";
            try {
                s = exchanger.exchange(s, 3, TimeUnit.SECONDS);
            } catch (InterruptedException | TimeoutException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);
        }, "t3").start();

    }
}
