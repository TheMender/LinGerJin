package Strategy;

import java.util.Arrays;

public class StrategyMain {
    public static void main(String[] args) {
        Cat[] a = {new Cat(3, 5), new Cat(4, 6), new Cat(1, 2)};
        Comparator<Cat> comparator = new CatComparator();
        Sorter<Cat> sorter = new Sorter<Cat>();
        sorter.sort(a, comparator);
        sorter.sort(a, (o1, o2) -> {
            if (o1.weight < o2.weight) return -1;
            else if (o1.weight > o2.weight) return 1;
            return 0;
        });
        System.out.println(Arrays.toString(a));
    }
}
