package linkedlist.cycle;

public class LinkedListCycleTest {

    static class Node {
        Node next;
        int data;
        Node (int data) {
            this.data = data;
            next = null;
        }
    }

    Node root;

    void printAllNodes () {
        Node start = root;
        System.out.println("Printing linkedlist");
        while (start.next != null) {
            System.out.print(start.data+", ");
            start = start.next;
        }
        System.out.println();
    }
    Node isCycle () {
        Node fast, slow, returnNode=null;
        fast = slow = root;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                fast = null;
            }
            if (fast == slow) {
                returnNode = slow;
                break;
            }
        }
        return returnNode;
    }
    void deleteCycle (Node slowCycle, Node head) {
        int k=1;
        for (Node start=slowCycle ; start.next!=slowCycle ; start=start.next) {
            k++;
        }
        System.out.println("k="+k);
        Node kthNode = head;
        for (int i=0 ; i<k ; i++) {
            kthNode = kthNode.next;
        }
        System.out.println("kthNode="+kthNode.data);

        while (kthNode != head) {
            kthNode = kthNode.next;
            head = head.next;
        }

        while (kthNode.next != head) {
            kthNode = kthNode.next;
        }
        kthNode.next = null;
    }

    public static void main (String []args) {
        LinkedListCycleTest linkedListCycleTest = new LinkedListCycleTest();
        /*Node node = new Node(12);
        linkedListCycleTest.root = node;
        node.next = new Node(15);
        node = node.next;
        node.next = new Node(18);
        node = node.next;
        Node cycleNode = node.next = new Node(22);
        node = node.next;
        node.next = new Node(24);
        node = node.next;
        node.next = new Node(25);
        node.next.next = cycleNode;*/


        Node node = new Node(1);
        linkedListCycleTest.root = node;
        node.next = new Node(2);
        node = node.next;
        Node cycleNode = node;
        node.next = new Node(3);
        node = node.next;
        node.next = new Node(4);
        node = node.next;
        node.next = new Node(5);
        node = node.next;
        node.next = cycleNode;


        //linkedListCycleTest.printAllNodes();
        Node slowNode = linkedListCycleTest.isCycle();
        System.out.println("isCycle="+(slowNode==null ? "False" : "True"));

        if (slowNode != null) {
            linkedListCycleTest.deleteCycle(slowNode, linkedListCycleTest.root);
        }

        slowNode = linkedListCycleTest.isCycle();
        System.out.println("isCycle="+(slowNode==null ? "False" : "True"));

        linkedListCycleTest.printAllNodes();
    }
}
