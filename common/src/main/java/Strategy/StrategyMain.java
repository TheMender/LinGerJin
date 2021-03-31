package Strategy;

import java.util.Arrays;

public class StrategyMain {
    public static void main(String[] args) {
        Cat[] a={new Cat(3,5),new Cat(4,6),new Cat(1,2)};
        Comparator<Cat> comparator=new CatComparator();
        Sorter<Cat> sorter=new Sorter<Cat>();
        sorter.sort(a,comparator);
        System.out.println(Arrays.toString(a));
    }
}
