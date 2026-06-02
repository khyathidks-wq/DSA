public class BellmanFord {

    public static void main(String[] args) {

        int V = 5;

        int edges[][] = {
            {0,1,4},
            {0,2,2},
            {2,1,-1},
            {1,3,3},
            {2,3,4},
            {3,4,2}
        };

        int dist[] = new int[V];

        for(int i=0;i<V;i++)
            dist[i] = 9999;

        dist[0] = 0;

        for(int i=1;i<V;i++) {

            for(int j=0;j<edges.length;j++) {

                int u = edges[j][0];
                int v = edges[j][1];
                int w = edges[j][2];

                if(dist[u] != 9999 &&
                   dist[u] + w < dist[v]) {

                    dist[v] = dist[u] + w;
                }
            }
        }

        System.out.println("Shortest Distances:");

        System.out.println("A = " + dist[0]);
        System.out.println("B = " + dist[1]);
        System.out.println("C = " + dist[2]);
        System.out.println("D = " + dist[3]);
        System.out.println("E = " + dist[4]);
    }
}