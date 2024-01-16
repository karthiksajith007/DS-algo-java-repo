package heap;

public class HeapTest {

    int []heap;
    final int size;
    int current;

    public HeapTest (int size) {
        this.size = size;
        current = 0;
        heap = new int [size];
    }
    int parent (int position) {
        return (position-1)/2;
    }
    int left (int position) {
        return (position*2) + 1;
    }
    int right (int position) {
        return (position*2) + 2;
    }
    void swap (int x, int y) {
        int temp = heap [x];
        heap [x] = heap [y];
        heap [y] = temp;
    }
    void insert (int value) {
        heap [current] = value;
        int index=current;
        while (heap[index] > heap[parent (index)]) {
            swap(index, parent (index));
            index = parent (index);
        }
        current++;
    }
    int extractLast () {
        int last = heap [0];
        heap [0] = heap[current--];
        doHeap(0);
        return last;
    }
    void doHeap (int position) {
        if (isLeaf(position)) {
            return ;
        }
        if (heap[position]<heap[left(position)] || heap[position]<heap[right(position)]) {
            if (heap[left(position)] > heap[right(position)]) {
                swap (left(position), position);
                doHeap(left(position));
            } else {
                swap (right(position), position);
                doHeap(right(position));
            }
        }
    }
    boolean isLeaf (int position) {
        boolean isLeaf = false;
        if (position>current/2 && position<=current) {
            isLeaf = true;
        }
        return isLeaf;
    }
    void print1toN () {
        for (int index=0 ; index<current/2 ; index++) {
            System.out.println("parent="+heap[index]);
            if (left(index)<current) {
                System.out.println("left="+heap[left(index)]);
            }
            if (right(index)<current) {
                System.out.println("right="+heap[right(index)]);
            }
        }
    }
    public static void main (String []args) {
        HeapTest heapTest = new HeapTest (15);
        heapTest.insert(5);
        heapTest.insert(3);
        heapTest.insert(17);
        heapTest.insert(10);
        heapTest.insert(84);
        heapTest.insert(19);
        heapTest.insert(6);
        heapTest.insert(22);
        heapTest.insert(9);

        heapTest.print1toN();

        //heapTest.heapify(0);

        //heapTest.printAll();
        //heapTest.print1toN();

        System.out.println("\nThe max val is " + heapTest.extractLast());
        System.out.println("\nThe max val is " + heapTest.extractLast());

    }
}
