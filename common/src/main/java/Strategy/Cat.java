package Strategy;

public class Cat implements Comparable<Cat>{
    int weight;
    int hight;

public Cat (int weight,int hight)
{
    this.weight=weight;
    this.hight=hight;

}

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", hight=" + hight +
                '}';
    }

    @Override
    public int compareTo(Cat cat){
        if(this.weight< cat.weight)
            return -1;
        else if(this.weight>cat.weight)
            return 1;
        else
            return 0;
    }
}
