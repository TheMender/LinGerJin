package practice;

/**
 * Title:
 * Desc:
 *
 * @author: linyongchao
 * Date: 2021/4/33:15 PM
 */
public class Sleep_Yiled_Join {
    public static void main(String[] args) {
//        sleep();
//        yield();
        join();
    }

    static void sleep() {
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("A" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    static void yield() {
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("A" + i);
                if (i % 10 == 0) {
                    Thread.yield();
                }

            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                System.out.println("B" + i);
                if (i % 10 == 0) {
                    Thread.yield();
                }

            }
        }).start();
    }

    static void join() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                System.out.println("A" + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println("t2 start");
                t1.join();
                System.out.println("t2 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t2.start();
        t1.start();

    }
}
