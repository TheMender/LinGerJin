package state;

public class MMSadState extends MMState {
    @Override
    public void smile() {
        System.out.println("Sad Smile");
    }

    @Override
    public void cry() {
        System.out.println("Sad Cry");
    }

    @Override
    public void say() {
        System.out.println("Sad Say");
    }
}
