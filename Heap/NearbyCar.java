package Heap;
import java.util.*;
public class NearbyCar {

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.distSq = x * x + y * y; // distance from origin squared
        }

        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq; // sort by distance
        }
    }

    public static void main(String args[]) {
        int pts[][] = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int i = 0; i < pts.length; i++) {
            pq.add(new Point(pts[i][0], pts[i][1]));
        }

        // print nearest K cars
        for (int i = 0; i < k; i++) {
            Point p = pq.remove();
            System.out.println("C" + (i + 1) + " -> (" + p.x + ", " + p.y + ")");
        }
    }
}