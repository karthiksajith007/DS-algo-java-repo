package binarytree;

public class AVLTreeAlternative {

    Node root = null;

    Node insert (Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        } else {
            return node;
        }
        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left), height(node.right));

        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(node);
        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && value < node.left.value)
            return rightRotate(node);
        // Right Right Case
        if (balance < -1 && value > node.right.value)
            return leftRotate(node);
        // Left Right Case
        if (balance > 1 && value > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // Right Left Case
        if (balance < -1 && value < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }
    int height(Node node) {
        if (node == null)
            return 0;

        return node.height;
    }
    int max(int a, int b) {
        return (a > b) ? a : b;
    }
    // Get Balance factor of node N
    int getBalance(Node N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }


    void delete (int value) {
        root = deleteNode(root, value);
    }
    Node deleteNode (Node node, int value) {
        if (node == null) {
            return null;
        }
        if (value < node.value) {
            node.left = deleteNode(node.left, value);
        } else if (value > node.value) {
            node.right = deleteNode(node.right, value);
        } else {
            if (node.left==null && node.right==null) {
                node = null;
            } else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else {
                Node minNode = minNode(node.right);
                node.value = minNode.value;
                node.right = deleteNode(node.right, value);
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
    void printInOrder () {
        System.out.println("Printing InOrder,");
        printInOrder(root);
        System.out.println();
    }
    void printInOrder (Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.value+", ");
            printInOrder(node.right);
        }
    }
    void printPreOrder () {
        System.out.println("Printing PreOrder,");
        printPreOrder(root);
        System.out.println();
    }
    void printPreOrder (Node node) {
        if (node != null) {
            System.out.print(node.value+", ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }
    public static void main (String []args) {

        AVLTreeAlternative bt = new AVLTreeAlternative();
        bt.root = bt.insert(bt.root,10);
        bt.root = bt.insert(bt.root,20);
        bt.root = bt.insert(bt.root, 30);
        bt.root = bt.insert(bt.root, 40);
        bt.root = bt.insert(bt.root, 50);
        bt.root = bt.insert(bt.root, 25);
        bt.printInOrder();

        //bt.delete(3);

        bt.printInOrder();
        bt.printPreOrder();

    }
}
