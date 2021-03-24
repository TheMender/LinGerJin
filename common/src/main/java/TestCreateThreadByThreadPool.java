import java.util.concurrent.*;

/**
 * Title:
 * Desc:
 *
 * @author: linyongchao
 * Date: 2021/3/1910:55 AM
 */
public class TestCreateThreadByThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(20, 20, 30, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
        executorService.submit(() -> {
            System.out.println("单个线程启动");
        });
        CompletableFuture.runAsync(()->System.out.println("Hello World!"));
    }
}
