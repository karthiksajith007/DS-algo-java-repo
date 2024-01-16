package linkedlist.cycle;

public class LinkedlistCycle {

    class Node {
        int data;
        Node next;
        Node (int data) {
            this.data = data;
        }
    }

    Node startNode = null , endNode = null;
    Node addNode (int data) {
        Node newNode = new Node (data);
        if (startNode == null) {
            startNode = newNode;
            endNode = newNode;
        } else {
            endNode.next = newNode;
            endNode = endNode.next;
        }
        return newNode;
    }
    void addNode (Node node) {
        endNode.next = node;
        endNode = endNode.next;
    }

    void printNodes () {
        Node itrNode = startNode;
        System.out.print("Data=");
        while (itrNode != null) {
            System.out.print(itrNode.data+",");
            itrNode = itrNode.next;

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    Node isCycle () {
        Node slowNode = null;
        Node itrNodeSlow = startNode, itrNodeFast = startNode;
        while (itrNodeFast!=null) {
            itrNodeSlow = itrNodeSlow.next;
            if (itrNodeFast.next != null) {
                itrNodeFast = itrNodeFast.next.next;
            } else {
                itrNodeFast = null;
            }

            if (itrNodeSlow == itrNodeFast) {
                System.out.println("itrNodeSlow="+itrNodeSlow.data);
                System.out.println("itrNodeFast="+itrNodeFast.data);
                slowNode = itrNodeSlow;
                break;
            }
        }
        return slowNode;
    }
    public void removeCycle(Node slow, Node head) {
        // Find the count of nodes involved in the loop
        int k = 1;
        for (Node ptr = slow; ptr.next != slow; ptr = ptr.next) {
            k++;
        }
        // Get a pointer to k'th node from the head
        Node curr = head;
        for (int i = 0; i < k; i++) {
            curr = curr.next;
        }
        // Simultaneously move the `head` and `curr` pointers at the same speed
        // until they meet.
        while (curr != head) {
            curr = curr.next;
            head = head.next;
        }
        // `curr` points to the last node of the loop
        while (curr.next != head) {
            curr = curr.next;
        }
        // set the next pointer of `curr` to `null` to break the chain
        curr.next = null;
    }

    public static void main (String []args) {
        LinkedlistCycle linkedlist = new LinkedlistCycle();
        /*Node head = linkedlist.addNode(0);
        linkedlist.addNode(8);
        Node node = linkedlist.addNode(12);
        linkedlist.addNode(20);
        linkedlist.addNode(22);
        linkedlist.addNode(26);
        linkedlist.addNode(30);
        linkedlist.addNode(35);
        linkedlist.addNode(node);*/
        //linkedlist.printNodes();

        Node head = linkedlist.addNode(1);
        Node node = linkedlist.addNode(2);
        linkedlist.addNode(3);
        linkedlist.addNode(4);
        linkedlist.addNode(5);
        linkedlist.addNode(node);

        Node slowNode = linkedlist.isCycle();
        if (slowNode!=null) {
            linkedlist.removeCycle(slowNode, head);
        }

        slowNode = linkedlist.isCycle();
        System.out.println("\nIsCycle="+(slowNode == null ? "false" : "true"));
    }
}
