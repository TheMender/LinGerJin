package practice;

import java.util.concurrent.TimeUnit;

/**
 * Title:
 * Desc:
 * 虽然双重检查线性安全不会出现多个对象，但是会出现在指令重排序有问题，因此需要加上volatile
 *
 * @author: linyongchao
 * Date: 2021/4/68:54 PM
 */
public class SingletonCheck {
    private static  /*volatile */ SingletonCheck singletonCheck;

    private SingletonCheck() {

    }

    public static SingletonCheck getInstance() {
        //业务逻辑等，锁代码块越小越好
        if (singletonCheck == null) {
            //双重检查
            synchronized (SingletonCheck.class) {
                if (singletonCheck == null) {
                    try {
                        TimeUnit.MICROSECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    singletonCheck = new SingletonCheck();
                }
            }

        }
        return singletonCheck;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(SingletonCheck.getInstance().hashCode())).start();
        }
    }
}
