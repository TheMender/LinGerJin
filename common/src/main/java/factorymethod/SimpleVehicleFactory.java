package factorymethod;

/**
 * 简单工厂的扩展性并不好
 */
public class SimpleVehicleFactory {
    public Car createCar()
    {
        System.out.println("生产Car了");
        return new Car();
    }

    public Plane createPlane()
    {
        System.out.println("生产Plane了");
        return new Plane();
    }

    public Broom createBroom()
    {
        System.out.println("生产Broom了");
        return new Broom();
    }
}
