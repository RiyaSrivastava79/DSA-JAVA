package Graph;
import java.util.*;

public class BFSGraph {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // --- Adding Edges ---
        // 0 vertex
        graph[0].add(new Edge(0, 1, 5));
        graph[0].add(new Edge(0, 2, 0)); // add missing edge to 2

        // 1 vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // 2 vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));
        graph[2].add(new Edge(2, 0, 0));

        // 3 vertex
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // 4 vertex
        graph[4].add(new Edge(4, 2, 2));
        graph[4].add(new Edge(4, 5, 1));

        // 5 vertex
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // 6 vertex
        graph[6].add(new Edge(6, 5, 1));
    }

    public static void bfs(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0); // start BFS from node 0

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) { // visit current node
                System.out.print(curr + " ");
                vis[curr] = true;

                // add all unvisited neighbors to the queue
                for (Edge e : graph[curr]) {
                    if (!vis[e.dest]) {
                        q.add(e.dest);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        //------------------- GRAPH DIAGRAM -------------------
        /*
                    1---3
                   /    | \
                  0     |  5--6
                  \     |  /
                    2---4
        */
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println("BFS Traversal of the graph:");
        bfs(graph);
    }
}
