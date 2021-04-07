package Iterator;

public class IteratorMain {
}

class ArrayList_ {
    Object[] objects = new Object[10];
    private int index = 0;

    public void add(Object o) {
        if (index == objects.length) {
            Object[] newobjects = new Object[objects.length << 1];
            System.arraycopy(objects, 0, newobjects, 0, objects.length);
            objects = newobjects;
        }
        objects[index] = o;
        index++;
    }

    public int size() {
        return objects.length;
    }
}
