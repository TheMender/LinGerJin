package practice;

/**
 * Title:
 * Desc:
 *
 * @author: linyongchao
 * Date: 2021/4/61:17 PM
 */
public class RunThread implements Runnable {
    private /*volatile*/ int count = 100;

    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        RunThread runThread = new RunThread();
        for (int i = 0; i < 100; i++) {
            new Thread(runThread, "RunThread" + i).start();
        }
    }
}
