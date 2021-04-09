package proxy;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * cglib实现动态代理不需要接口
 */
public class Cglib {
    public static void main(String[] args) {
        Enhancer enhancer=new Enhancer();
    }
}
class TimeMethodInterceptor implements MethodInterceptor{

}

class Tank{
    public void move(){
        System.out.println("Tank moving claclacla...");
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
