package Graph;
import java.util.*;

public class Connectingcities {

    // Edge class implementing Comparable for priority queue sorting by cost
    static class Edge implements Comparable<Edge> {
        int dest;
        int cost;

        public Edge(int d, int c) {
            this.dest = d;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.cost - e2.cost; // ascending order by cost
        }
    }

    // Function to find minimum cost to connect all cities
    public static int connectCities(int[][] cities) {
        boolean[] vis = new boolean[cities.length];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // Start from city 0
        pq.add(new Edge(0, 0));
        int finalCost = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.remove();

            if (!vis[curr.dest]) {
                vis[curr.dest] = true;
                finalCost += curr.cost;

                // Add all unvisited neighbors
                for (int i = 0; i < cities[curr.dest].length; i++) {
                    if (cities[curr.dest][i] != 0 && !vis[i]) {
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    }
                }
            }
        }

        return finalCost;
    }

    // Main method
    public static void main(String[] args) {
        int[][] cities = {
            {0, 1, 2, 3, 4},
            {1, 0, 5, 6, 7},
            {2, 5, 0, 6, 0},
            {3, 6, 6, 0, 0},
            {4, 7, 0, 0, 0}
        };

        System.out.println("Minimum cost to connect all cities: " + connectCities(cities));
    }
}