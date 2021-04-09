package factorymethod;

public class Main {
    public static void main(String[] args) {
//        Car car=new Car();
//        car.go();
//        Plane plane=new Plane();
//        plane.go();
//        Moveable moveable=new CarFactory().createCar();
//        moveable.go();
//        Weapon w=new Ak47();
//        w.shoot();
//        Bread bread=new Bread();
//        bread.printName();
        AbstractFactory factory = new ModernFactory();
        Food food = factory.createFood();
        food.printName();
        Vehicle vehicle = factory.createVehicle();
        vehicle.go();
        Weapon weapon = factory.createWeapon();
        weapon.shoot();
    }
}
