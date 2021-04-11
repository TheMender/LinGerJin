package Prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 自带
 * 实现原型模式需要实现标记型接口(无任何方法)Cloneable
 * 一般会重写clone()方法，如果只是重写clone方法而没有实现接口会异常
 * 一般用于一个对象已经确定需要产生很多相同参数的时候
 * 需要区分深克隆还是浅克隆
 */
public class ProtoType {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person();
        Person p2 = (Person) p1.clone();
        System.out.println(p2.toString());

        System.out.println(p1.location == p2.location);
        p1.location.street = "313";
        System.out.println(p2.location);
    }
}

@Data
class Person implements Cloneable {
    int age = 18;
    int weight = 140;
    Location location = new Location("212 street", 20);

    public Object clone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();
        p.location = (Location) location.clone();
        return p;
    }
}

@Data
@AllArgsConstructor
class Location implements Cloneable {
    String street;
    int room;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
