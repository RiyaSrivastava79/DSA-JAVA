package Graph;
import java.util.*;

public class isBipartiteGraph {

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // ---------- Create Graph ----------
    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // ---------- Sample Graph ----------
        // if graph does not has cycle it is bipartite graph
        /*
                 0 ---- 1
                 |      |
                 |      |
                 3 ---- 2

           This graph is Bipartite.
        */

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 2));
    }

    // ---------- Check if Graph is Bipartite ----------
    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int col[] = new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i] = -1; // no color initially
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) { // BFS for uncolored component
                q.add(i);
                col[i] = 0; // color start node as yellow (0)

                while (!q.isEmpty()) {
                    int curr = q.remove();

                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);

                        if (col[e.dest] == -1) {
                            // Assign opposite color
                            int nextColor = (col[curr] == 0) ? 1 : 0;
                            col[e.dest] = nextColor;
                            q.add(e.dest);
                        } else if (col[e.dest] == col[curr]) {
                            // Same color neighbor → not bipartite
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    // ---------- Main Method ----------
    public static void main(String args[]) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        if (isBipartite(graph)) {
            System.out.println("Graph is Bipartite.");
        } else {
            System.out.println("Graph is NOT Bipartite.");
        }
    }
}
