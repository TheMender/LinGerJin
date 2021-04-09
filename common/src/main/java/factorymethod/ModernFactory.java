package factorymethod;

public class ModernFactory extends AbstractFactory{
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Weapon createWeapon() {
        return new Ak47();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }
}
