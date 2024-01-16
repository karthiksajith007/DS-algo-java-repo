package binarytree;

public class AVLTreeTest {

    Node root = null;

    Node insert (Node node, int value) {
        if (node == null) {
            return new Node (value);
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
            int balance = balance(node);
            if (balance > 1) {
                if (value < node.left.value) {
                    node = rotateRight(node);
                } else if (value > node.left.value) {
                    node.left = rotateLeft(node.left);
                    node = rotateRight(node);
                }
            }
        } else if (value > node.value) {
            node.right = insert(node.right, value);
            int balance = balance(node);
            if (balance < -1) {
                if (value > node.right.value) {
                    node = rotateLeft(node);
                } else if (value < node.right.value) {
                    node.right = rotateRight(node.right);
                    node = rotateLeft(node);
                }
            }
        } else {}
        node.height = 1 + max (height(node.left), height(node.right));
        return node;
    }

    Node delete (Node node, int value) {
        if (node == null) {
            return null;
        }
        if (value < node.value) {
            node.left = delete(node.left, value);
        } else if (value > node.value) {
            node.right = delete(node.right, value);
        } else {
            if (node.left==null && node.right==null) {
                node = null;
            } else if (node.left==null) {
                node = node.right;
            } else if (node.right==null) {
                node = node.left;
            } else {
                Node temp = minNode(node.right);
                node.value = temp.value;
                node.right = delete(node.right, temp.value);
            }
        }
        node.height = 1 + max (height(node.left), height(node.right));
        int balance = balance(node);
        if (balance > 1) {
            if (balance (node.left) >= 0) {
                node = rotateRight(node);
            } else {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        } else if (balance < -1) {
            if (balance (node.right) <= 0) {
                node = rotateLeft(node);
            } else {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }
        return node;
    }
    Node rotateLeft (Node node) {
        Node right = node.right;
        Node rightLeft = right.left;

        right.left = node;
        node.right = rightLeft;

        node.height = 1 + max(height(node.left), height(node.right));
        right.height = 1 + max(height(right.left), height(right.right));

        return right;
    }
    Node rotateRight (Node node) {
        Node left = node.left;
        Node leftRight = left.right;

        left.right = node;
        node.left = leftRight;

        node.height = 1 + max(height(node.left), height(node.right));
        left.height = 1 + max(height(left.left), height(left.right));

        return left;
    }
    int max (int x, int y) {
        return x>y ? x : y;
    }
    int height (Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }
    int balance (Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }
    Node minNode (Node node) {
        if (node.left==null) {
            return minNode(node.left);
        }
        return node;
    }
    void preOrder () {
        System.out.println("Printing pre-order");
        preOrder(root);
        System.out.println();
    }
    void preOrder (Node node) {
        if (node != null) {
            System.out.print(node.value+", ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void main (String []args) {
        AVLTreeTest tree = new AVLTreeTest();

        /* Constructing tree given in the above figure */

        tree.root = tree.insert(tree.root, 9);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 0);
        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 11);
        tree.root = tree.insert(tree.root, -1);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 2);

        tree.preOrder();

        tree.root = tree.delete(tree.root, 10);

        tree.preOrder();
    }
}