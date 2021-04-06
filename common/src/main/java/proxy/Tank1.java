package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;


public class Tank1 implements Movable {

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        System.out.println("tack1 move");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void main(String[] args) {
//        new TankTimeProxy(new Tank1()).move();
//        new TankTimeProxy(new TankLogProxy(new Tank1())).move();
        Tank1 tank1 = new Tank1();
        //reflection 通过二进制字节码文件分析类的属性和方法
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        Movable m = (Movable) Proxy.newProxyInstance(Tank1.class.getClassLoader(),
                new Class[]{Movable.class}, new TankInvocationHandler(tank1)
//                {
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        long start = System.currentTimeMillis();
//                        tank1.move();
//                        long end = System.currentTimeMillis();
//                        System.out.println(end - start);
//                        return tank1;
//                    }
//                }
        );
        m.move();
    }
}

class TankInvocationHandler implements InvocationHandler {

    public TankInvocationHandler(Movable move) {
        this.move = move;
    }

    Movable move;

    //getClass.getMethods()

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //proxy为动态生成的代理对象
        //method,move，相当于move.move
        System.out.println("start");
        Object o = method.invoke(move, args);
        System.out.println("end");
        return o;
    }
}

class TankTimeProxy implements Movable {

    public TankTimeProxy(Movable move) {
        this.move = move;
    }

    Movable move;

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        move.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

class TankLogProxy implements Movable {

    public TankLogProxy(Movable move) {
        this.move = move;
    }

    Movable move;

    @Override
    public void move() {
        System.out.println("start");
        move.move();
        System.out.println("end");
    }
}

interface Movable {
    void move();
}
