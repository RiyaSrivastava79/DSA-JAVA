package Graph;
import java.util.*;

public class DFSGraph {

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

        // 0 vertex
        graph[0].add(new Edge(0, 1, 5));
        graph[0].add(new Edge(0, 2, 0));

        // 1 vertex - reorder to visit 3 first
        graph[1].add(new Edge(1, 3, 3));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 0, 5));

        // 2 vertex
        graph[2].add(new Edge(2, 4, 2));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 0, 0));

        // 3 vertex
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // 4 vertex
        graph[4].add(new Edge(4, 2, 2));
        graph[4].add(new Edge(4, 5, 1));

        // 5 vertex
        graph[5].add(new Edge(5, 6, 1));
        graph[5].add(new Edge(5, 4, 1));

        // 6 vertex
        graph[6].add(new Edge(6, 5, 1));
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis) {
        System.out.print(curr + " ");
        vis[curr] = true;

        for (Edge e : graph[curr]) {
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
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
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        System.out.println("DFS Traversal of the graph:");
        dfs(graph, 0, new boolean[V]);
    }
}

