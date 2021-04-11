package state;

public class MM {
    String name;
    MMState state;

    public void smile() {
        state.smile();
    }

    public void cry() {
        state.cry();
    }

    public void say() {
        state.say();
    }

    public static void main(String[] args) {
        MM m = new MM();
        m.name = "2";
        m.state = new MMHappyState();
        m.smile();
        m.cry();
    }
}
