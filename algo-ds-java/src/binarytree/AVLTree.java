package binarytree;

public class AVLTree {

    Node root = null;

    void insert (int value) {
        root = insert(root, value);
    }
    Node insert (Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
            if (balance(node) > 1) {
                if (value < node.left.value) {
                    node = rotateRight(node);
                } else {
                    node.left = rotateLeft(node.left);
                    node = rotateRight(node);
                }
            }
        } else if (value > node.value) {
            node.right = insert(node.right, value);
            if (balance(node) < -1) {
                if (value > node.right.value) {
                    node = rotateLeft(node);
                } else {
                    node.right = rotateRight(node.right);
                    node = rotateLeft(node);
                }
            }
        } else {
            return node;
        }
        node.height = 1 + max(height(node.left), height(node.right));
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
            } else if (node.right == null) {
                node = node.left;
            } else if (node.left == null) {
                node = node.right;
            } else {
                Node temp = minNode(node.right);
                node.value = temp.value;
                node.right = delete(node.right, temp.value);
            }
        }
        if (node == null) {
            return node;
        }
        node.height = 1 + max(height(node.left), height(node.right));

        int balance = balance(node);
        if (balance > 1) {
            if (balance (node.left) >= 0/*value < node.left.value*/) {
                node = rotateRight(node);
            }
            if (balance(node.left) < 0) {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        } else if (balance(node) < -1) {
            if (balance(node.right) <= 0/*value > node.right.value*/) {
                node = rotateLeft(node);
            }
            if (balance(node.right) > 0) {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }
        return node;
    }
    Node minNode (Node node) {
        if (node.left != null) {
            return minNode(node.left);
        }
        return node;
    }

    Node rotateRight (Node node) {
        Node left = node.left;
        Node leftRight = left.right;

        left.right = node;
        node.left = leftRight;

        node.height = 1 + max (height(node.left), height(node.right));
        left.height = 1 + max (height(left.left), height(left.right));

        return left;
    }
    Node rotateLeft (Node node) {
        Node right = node.right;
        Node rightLeft = right.left;

        right.left = node;
        node.right = rightLeft;

        node.height = 1 + max (height(node.left), height(node.right));
        right.height = 1 + max (height(right.left), height(right.right));

        return right;
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
    int max (int x, int y) {
        return x>y ? x : y;
    }

    void preOrder () {
        System.out.println("Pre order");
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
        AVLTree tree = new AVLTree();

        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        tree.preOrder();
        tree.root = tree.delete(tree.root, 20);
        tree.preOrder();
    }
}
