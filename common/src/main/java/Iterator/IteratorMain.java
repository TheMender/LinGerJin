package Iterator;

import java.util.Arrays;

public class IteratorMain {
    public static void main(String[] args) {
        Collection_ arrayList = new ArrayList_();
        Collection_ linkList_ = new LinkList_();
        for (int i = 0; i < 15; i++) {
            linkList_.add(i);
        }
        System.out.println(linkList_.size());
        System.out.println(linkList_.toString());

        Iteator_ iteator_ = linkList_.iteator();
        if (iteator_.hasNext()) {
            Object o = iteator_.next();
            System.out.println(o);
        }
    }
}


class LinkList_<E> implements Collection_<E> {
    Node head = null;
    Node tail = null;
    //目前有多少個元素
    private int size = 0;

    public void add(E o) {
        Node n = new Node(o);
        if (head == null) {
            head = n;
            tail = n;
        }
        tail.next = n;
        tail = n;
        size++;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "LinkList_{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }

    class Node {
        E o;
        Node next;

        public Node(E o) {
            this.o = o;
        }
    }

    public Iteator_ iteator() {
        return new LinkListIterator();
    }

    class LinkListIterator implements Iteator_ {

        private Node lastNext;
        private Node next;

        private int nextIndex = 0;

        @Override
        public boolean hasNext() {
            if (nextIndex > size)
                return false;
            else return true;
        }

        @Override
        public E next() {
            if (nextIndex == 0) {
                next = head;
            }
            if (hasNext()) {
                lastNext = next;
                next = next.next;
                nextIndex++;
            }
            return null;
        }
    }
}

class ArrayList_<E> implements Collection_<E> {
    E[] objects = (E[]) new Object[10];
    private int index = 0;

    public void add(E o) {
        if (index == objects.length) {
            E[] newobjects = (E[]) new Object[objects.length << 1];
            System.arraycopy(objects, 0, newobjects, 0, objects.length);
            objects = newobjects;
        }
        objects[index] = o;
        index++;
    }

    public int size() {
        return objects.length;
    }

    @Override
    public Iteator_ iteator() {
        return new ArrayListIterator();
    }

    @Override
    public String toString() {
        return "ArrayList_{" +
                "objects=" + Arrays.toString(objects) +
                ", index=" + index +
                '}';
    }

    class ArrayListIterator implements Iteator_ {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            if (currentIndex > index)
                return false;
            else return true;
        }

        @Override
        public E next() {
            if (hasNext()) {
                E o = objects[currentIndex++];
                return o;
            }
            return null;
        }
    }
}
