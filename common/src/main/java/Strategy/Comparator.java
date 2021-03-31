package Strategy;

@FunctionalInterface
public interface Comparator<T> {
    int compare(T o1, T o2);

    default void output() {
        System.out.println("这里可以写默认实现！");
    }
}
