package factorymethod;

public class CarFactory {

    public Moveable createCar(){
        System.out.println("a Car Created!");
        return new Car();
    }
}
