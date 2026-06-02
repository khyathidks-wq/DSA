import java.util.Arrays;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

public class KruskalMST {

    static int[] parent;

    static int find(int i) {
        if (parent[i] == i)
            return i;
        return find(parent[i]);
    }

    static void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        parent[xRoot] = yRoot;
    }

    public static void main(String[] args) {

        int vertices = 5;

        Edge[] edges = {
            new Edge(0, 1, 1),
            new Edge(0, 2, 2),
            new Edge(1, 3, 5),
            new Edge(2, 3, 8),
            new Edge(3, 4, 2),
            new Edge(2, 4, 10)
        };

        parent = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }

        Arrays.sort(edges);

        int totalCost = 0;

        System.out.println("Selected Edges:");

        for (Edge edge : edges) {

            int x = find(edge.src);
            int y = find(edge.dest);

            if (x != y) {

                System.out.println(
                        edge.src + " - " +
                        edge.dest + " = " +
                        edge.weight);

                totalCost += edge.weight;

                union(x, y);
            }
        }

        System.out.println("Total Cost = " + totalCost);
    }
}