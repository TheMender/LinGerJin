package proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * cglib实现动态代理不需要接口
 */
public class Cglib {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        TimeMethodInterceptor interceptor = new TimeMethodInterceptor();
        enhancer.setCallback(interceptor);
        enhancer.setSuperclass(Tank.class);
        Tank tank = (Tank) enhancer.create();
        tank.move();
    }
}
class TimeMethodInterceptor implements MethodInterceptor{

}

class Tank {
    public void move() {
        System.out.println("Tank moving claclacla...");
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
