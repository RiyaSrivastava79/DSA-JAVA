package Graph;
import java.util.*;

public class DisjointSet {

    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    // Initialize each node as its own parent
    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 0;
        }
    }

    // Find function with path compression
    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }
        // Path compression
        par[x] = find(par[x]);
        return par[x];
    }

    // Union function with union by rank
    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (parA == parB) return; // already in the same set

        // attach smaller rank tree under root of higher rank tree
        if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else if (rank[parA] > rank[parB]) {
            par[parB] = parA;
        } else {
            par[parB] = parA;
            rank[parA]++;
        }
    }

    public static void main(String args[]) {
        init();

        System.out.println(find(3)); // Initially, 3 is its own parent

        union(1, 3);
        System.out.println(find(3)); // After union(1,3)

        union(2, 4);
        union(3, 6);
        union(1, 4);

        System.out.println(find(3)); // Check representative of 3
        System.out.println(find(4)); // Check representative of 4

        union(1, 5);
        System.out.println(find(5)); // Representative of 5
    }
}