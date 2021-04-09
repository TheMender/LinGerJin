package Strategy;

public class Dog implements Comparable<Dog> {
    int food;

    public Dog(int food) {
        this.food = food;
    }

    @Override
    public int compareTo(Dog o) {
        if (o.food > this.food)
            return 1;
        else if (o.food < this.food)
            return -1;
        else return 0;
    }
}
