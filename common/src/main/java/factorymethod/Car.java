package factorymethod;

public class Car extends Vehicle implements Moveable{
    public void go(){
        System.out.println("开车了");
    }
}
