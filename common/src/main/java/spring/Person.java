package spring;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Title:
 * Desc:
 *
 * @author: linyongchao
 * Date: 2021/4/101:26 PM
 */
@Data
@AllArgsConstructor
public class Person {
    private int age;
    private int weight;
    private int height;
    private Food food;

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
