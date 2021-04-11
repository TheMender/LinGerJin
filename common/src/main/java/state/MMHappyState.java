package state;

public class MMHappyState extends MMState {
    @Override
    public void smile() {
        System.out.println("Happy Smile");
    }

    @Override
    public void cry() {
        System.out.println("Happy Cry");
    }

    @Override
    public void say() {
        System.out.println("Happy Say");
    }
}
