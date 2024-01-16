package binarytree;

public class Node {

    public int value, height;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
        height = 1;
        right = null;
        left = null;
    }
}
