package Graph;
import java.util.*;

public class CycleDetectionbfs {

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Create the graph
    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // --- Adding Edges ---
        // Component (contains a cycle)
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    // Detect cycle in all connected components
    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true; // cycle found
                }
            }
        }
        return false;
    }

    // DFS to detect cycle
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, int par) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // If neighbor not visited, visit it
            if (!vis[e.dest]) {
                if (detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            }
            // If visited and not parent, cycle exists
            else if (e.dest != par) {
                return true;
            }
            // else if visited and is parent → skip it (continue to next neighbor)
        }

        // No cycle found for this node
        return false;
    }

    public static void main(String[] args) {
        //------------------- GRAPH DIAGRAM -------------------
        /*
                    0-----3
                   /       \
                  1         4
                   \
                    2
        */
        int V = 2;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        if (detectCycle(graph)) {
            System.out.println("Cycle exists in the graph.");
        } else {
            System.out.println("No cycle found in the graph.");
        }
    }
}
