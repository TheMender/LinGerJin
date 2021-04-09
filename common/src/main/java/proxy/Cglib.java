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
    }
}

class TimeMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return null;
    }
}

class Tank {
    public void move() {
        System.out.println("Tank moving claclacla...");
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
