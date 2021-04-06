package practice;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * Title:
 * Desc:模拟银行账户，对写方法加锁,读方法不加锁，出现脏读（dirtyRead）
 * 一个同步方法可以调另一个同步方法，一个线程已经拥有某个对象的锁，再次申请的时候仍然会获得该对象的锁，也就是说synchronized是可重入锁
 *
 * @author: linyongchao
 * Date: 2021/4/61:39 PM
 */
public class Account {
    String name;
    BigDecimal balance;

    public synchronized void set(String name, BigDecimal balance) {
        this.name = name;
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public /*synchronized*/ BigDecimal get(String name) {
        return this.balance;
    }

    public static void main(String[] args) {
        Account account = new Account();
        new Thread(() -> account.set("账户", BigDecimal.TEN)).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account.get("账户"));
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account.get("账户"));
    }
}
