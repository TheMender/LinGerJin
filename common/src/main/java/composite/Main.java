package composite;

import java.util.ArrayList;
import java.util.List;

abstract class Node {
    abstract public void print();
}

class LeafNode extends Node {
    String content;

    public LeafNode(String content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println(content);
    }
}

class BranchNode extends Node {
    List<Node> list = new ArrayList<>();
    String name;

    public BranchNode(String name) {
        this.name = name;
    }

    void add(Node node) {
        this.list.add(node);
    }

    @Override
    public void print() {
        System.out.println(name);
    }

}

public class Main {
    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");
        BranchNode chapter1 = new BranchNode("chapter1");
        BranchNode chapter2 = new BranchNode("chapter2");
        Node c11 = new LeafNode("c11");
        Node c12 = new LeafNode("c12");
        BranchNode b21 = new BranchNode("section21");
        Node c211 = new LeafNode("c211");
        Node c212 = new LeafNode("c212");

        root.add(chapter1);
        root.add(chapter2);
        chapter1.add(c11);
        chapter1.add(c12);
        chapter2.add(b21);
        b21.add(c211);
        b21.add(c212);

//        tree(root);
        tree2(root,0);
    }

    public static void tree(Node root) {
        root.print();
        if (root instanceof BranchNode) {
            for (Node n : ((BranchNode) root).list) {
                tree(n);
            }
        }
    }

    public static void tree2(Node root,int depth) {
        for(int i=0;i<depth;i++)
        {
            System.out.print("--");
        }
        root.print();
        if (root instanceof BranchNode) {
            for (Node n : ((BranchNode) root).list) {
                tree2(n,depth+1);
            }
        }
    }
}
