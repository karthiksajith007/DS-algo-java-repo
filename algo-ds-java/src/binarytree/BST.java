package binarytree;

public class BST {

    Node root = null;

    //insert recursive
    Node insert (Node node, int value) {
        if (node == null) {
            return new Node (value);
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        }
        return node;
    }
    //Insert iterative
    void insert (int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return ;
        }
        Node currentNode = root, parent=null;
        while (true) {
            parent = currentNode;
            if (data < currentNode.value) {
                currentNode = currentNode.left;
                if (currentNode == null) {
                    parent.left = newNode;
                    return ;
                }
            } else if (data > currentNode.value) {
                currentNode = currentNode.right;
                if (currentNode == null) {
                    parent.right = newNode;
                    return ;
                }
            }
        }
    }

    public void deleteNode (int value) {
        deleteNode(root, value);
    }
    Node deleteNode (Node deleteNode, int value) {
        if (deleteNode == null) {
            return null;
        }
        if (value < deleteNode.value) {
            deleteNode.left = deleteNode (deleteNode.left, value);
        } else if (value > deleteNode.value) {
            deleteNode.right = deleteNode (deleteNode.right, value);
        } else {
            if (deleteNode.left==null && deleteNode.right==null) {
                deleteNode = null;
            } else if (deleteNode.left==null) {
                deleteNode = deleteNode.right;
            } else if (deleteNode.right==null) {
                deleteNode = deleteNode.left;
            } else {
                //If node to be deleted has 2 children
                Node temp = minNode(deleteNode.right);
                deleteNode.value = temp.value;
                deleteNode.right = deleteNode (deleteNode.right, temp.value);
            }
        }
        return deleteNode;
    }
    Node minNode (Node node) {
        if (node.left != null) {
            return minNode(node.left);
        }
        return node;
    }
    private void inOrder (Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print (node.value+", ");
            inOrder(node.right);
        }
    }

    public void printInOrder () {
        System.out.println ("Printing inOrder");
        inOrder (root);
        System.out.println ();
    }

    public static void main (String []args) {
        BST bt = new BST();
        bt.insert(52);
        bt.insert(15);
        bt.insert(56);
        bt.insert(9);
        bt.insert(11);
        bt.insert(54);
        bt.insert(3);
        bt.insert(5);
        bt.insert(61);
        bt.printInOrder();

        bt.deleteNode(3);

        bt.printInOrder();
    }
}
