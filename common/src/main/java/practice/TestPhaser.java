package practice;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Title:
 * Desc:
 *
 * @author: linyongchao
 * Date: 2021/4/85:26 PM
 */
public class TestPhaser {
    static Random r = new Random();
    static MarriagePhaser phaser = new MarriagePhaser();

    public static void main(String[] args) {
        phaser.bulkRegister(7);
        for (int i = 0; i < 5; i++) {
            new Thread(new Person("p" + i)).start();
        }
        new Thread(new Person("新郎")).start();
        new Thread(new Person("新娘")).start();
    }


    static class MarriagePhaser extends Phaser {
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {

            switch (phase) {
                case 0:
                    System.out.println("所有人到齐了！" + registeredParties);
                    System.out.println();
                    return false;
                case 1:
                    System.out.println("所有人吃完了！" + registeredParties);
                    System.out.println();
                    return false;
                case 2:
                    System.out.println("所有人离开了！" + registeredParties);
                    System.out.println();
                    return false;
                case 3:
                    System.out.println("婚礼结束，新郎新娘入洞房！" + registeredParties);
                    System.out.println();
                    return true;
                default:
                    return true;
            }

        }
    }

    static class Person extends Thread {
        String name;

        public Person(String name) {
            this.name = name;
        }

        public void arrive() {
            secondSleep(3);
            System.out.printf("%s 到达现场!\n", name);
            phaser.arriveAndAwaitAdvance();
        }

        public void eat() {
            secondSleep(5);
            System.out.printf("%s 吃完!\n", name);
            phaser.arriveAndAwaitAdvance();
        }

        public void leave() {
            secondSleep(2);
            System.out.printf("%s 离开!\n", name);
            phaser.arriveAndAwaitAdvance();
        }

        public void hug() {
            if (name.equals("新郎") || name.equals("新娘")) {
                secondSleep(10);
                System.out.printf("%s 入洞房", name);
                phaser.arriveAndAwaitAdvance();
            } else {
                phaser.arriveAndDeregister();
//                phaser.register();//增加一个
            }

        }

        @Override
        public void run() {
            arrive();

            eat();

            leave();

            hug();
        }
    }

    private static void secondSleep(int sleep) {
        try {
            TimeUnit.SECONDS.sleep(r.nextInt(sleep));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


