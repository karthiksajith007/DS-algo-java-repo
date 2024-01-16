package graph.linkedlistgraph;

import java.util.*;

public class GraphTest {

    List <List<Integer>> graph;
    final int size;

    GraphTest (int n) {
        size = n;
        graph = new ArrayList<>(n);
        for (int i=0 ; i<n ; i++) {
            graph.add(new LinkedList<Integer>());
        }
    }
    void addVertex (int vertex) {
        graph.get(vertex);
    }
    void addEdge (int v1, int v2, boolean biDirectional) {
        if (!graph.get(v1).contains(v2)) {
            graph.get(v1).add(v2);
        }
        if (biDirectional) {
            if (!graph.get(v2).contains(v1)) {
                graph.get(v2).add(v1);
            }
        }
    }
    boolean hasEdge (int v1, int v2) {
        boolean hasEdge = false;
        graph.get(v1);
        graph.get(v1).contains(v2);
        if (graph.get(v1).contains(v2)) {
            hasEdge = true;
        } else if (graph.get(v2).contains(v1)) {
            hasEdge = true;
        }
        return hasEdge;
    }
    void printAll () {
        for (int i=0; i<size ; i++) {
            System.out.println("Printing "+i);
            Iterator itr = graph.get(i).iterator();
            while (itr.hasNext()) {
                System.out.print(itr.next()+", ");
            }
            System.out.println();
        }
    }

    boolean isCyclical () {
        boolean isCyclical = false;
        boolean []visited = new boolean[size];
        for (int i=0 ; i<size ; i++) {
            visited[i] = false;
        }
        for (int i=0 ; i<size ; i++) {
            if (!visited[i]) {
                if (isCyclical (i, visited, -1)) {
                    return true;
                }
            }
        }
        return isCyclical;
    }
    boolean isCyclical (int rowIndex, boolean []visited, int parent) {
        visited [rowIndex] = true;
        Iterator<Integer> iterator = graph.get(rowIndex).iterator();
        while (iterator.hasNext()) {
            Integer data = iterator.next();
            if (!visited[data]) {
                if (isCyclical(data, visited, rowIndex)) {
                    return true;
                }
            } else if (data!=parent) {
                return true;
            }
        }
        return false;
    }
    public static void main (String []args) {
        GraphTest graph = new GraphTest(5);
        /*graph.addEdge(0, 1, true);
        graph.addEdge(0, 2, true);
        graph.addEdge(1, 2, true);
        graph.addEdge(2, 0, true);
        graph.addEdge(2, 3, true);
        graph.addEdge(3, 3, true);*/
        graph.addEdge(0, 1, true);
        graph.addEdge(0, 2, true);
        //graph.addEdge(1, 4, true);
        graph.addEdge(1, 2, true);
        graph.addEdge(0, 3, true);
        graph.addEdge(3, 4, true);


        //graph.printAll();

        //System.out.println("hasEdge="+graph.hasEdge(3,4));
        System.out.println("\nisCyclical="+graph.isCyclical());
    }
}
