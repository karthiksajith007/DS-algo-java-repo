package linkedlist.duplpicate;

public class LinkedListDeleteTry {

    public class Node {
        int data;
        Node next;
        public Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node startNode=null, endNode=null;

    void addNode (int data) {
        Node newNode = new Node(data);
        if (startNode == null) {
            startNode = newNode;
            endNode = startNode;
            startNode.next = null;
        } else {
            endNode.next = newNode;
            endNode = endNode.next;
        }
    }

    void displayAllNodes () {
        Node itrNode = startNode;
        System.out.print("\nitrNodes= ");
        while (itrNode != null) {
            System.out.print(itrNode.data + ", ");
            itrNode = itrNode.next;
        }
    }
    void deleteDuplicateNodes () {
        Node itrNode = startNode;
        while (itrNode != null) {
            //int data = itrNode.data;
            Node itrNode2 = itrNode.next;
            Node tempNode = itrNode;
            while (itrNode2 != null) {
                if (itrNode.data == itrNode2.data) {
                    //delete itrNode2
                    tempNode.next = itrNode2.next;
                } else {
                    tempNode = itrNode2;
                }
                itrNode2 = itrNode2.next;
            }
            itrNode = itrNode.next;
        }
    }
    public static void main (String []args) {
        LinkedListDeleteTry linkedList = new LinkedListDeleteTry();
        linkedList.addNode(1);
        linkedList.addNode(5);
        linkedList.addNode(5);
        linkedList.addNode(10);
        linkedList.addNode(10);

        linkedList.displayAllNodes();

        linkedList.deleteDuplicateNodes();

        linkedList.displayAllNodes();
    }
}
