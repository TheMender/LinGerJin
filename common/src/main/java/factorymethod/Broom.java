package factorymethod;

public class Broom extends Vehicle implements Moveable {
    @Override
    public void go() {
        System.out.println("broom flying shuashusashua");
    }
}
