package factorymethod;

public abstract class AbstractFactory {
    abstract Food createFood();
    abstract Weapon createWeapon();
    abstract Vehicle createVehicle();
}
