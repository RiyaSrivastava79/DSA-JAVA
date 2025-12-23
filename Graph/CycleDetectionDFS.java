package Graph;
import java.util.*;

public class CycleDetectionDFS {

    static class Edge {
        int src;
        int dest;
        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // ---------- Create Graph ----------
    static void createGraph(ArrayList<Edge>[] graph) { // FALSE = no cycle
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // ---------- Sample Graph ----------
        /*
              0 → 1 → 2
                   ↑   ↓
                   ←---3
           This graph contains a cycle.
        */

        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1)); // back edge → cycle
    }

    // ---------- Cycle Detection (DFS) ----------
    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    // ---------- DFS Helper ----------
    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest]) {
                // Node already in recursion stack → cycle found
                return true;
            }
            if (!vis[e.dest]) {
                if (isCycleUtil(graph, e.dest, vis, stack)) {
                    return true;
                }
            }
        }

        stack[curr] = false; // remove from recursion stack
        return false;
    }

    // ---------- Main Method ----------
    public static void main(String args[]) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        if (isCycle(graph)) {
            System.out.println("Graph contains a cycle.");
        } else {
            System.out.println("Graph does NOT contain a cycle.");
        }
    }
}
