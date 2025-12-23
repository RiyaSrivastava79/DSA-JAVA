package GreedyAlgorithm;

import java.util.*;

public class Chocolaproblem {
    public static void main(String[] args) {
        int n = 4, m = 6;
        Integer costVer[] = {2, 1, 3, 1, 4}; // vertical cuts (m-1)
        Integer costHor[] = {4, 1, 2};       // horizontal cuts (n-1)

        // Sort in descending order
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0; // indices
        int hp = 1, vp = 1; // pieces count
        int cost = 0;

        // Greedy approach: pick the larger cost first
        while (h < costHor.length && v < costVer.length) {
            if (costVer[v] <= costHor[h]) {
                // horizontal cut
                cost += costHor[h] * vp;
                hp++;
                h++;
            } else {
                // vertical cut
                cost += costVer[v] * hp;
                vp++;
                v++;
            }
        }

        // Remaining horizontal cuts
        while (h < costHor.length) {
            cost += costHor[h] * vp;
            hp++;
            h++;
        }

        // Remaining vertical cuts
        while (v < costVer.length) {
            cost += costVer[v] * hp;
            vp++;
            v++;
        }

        System.out.println("Minimum cost of cuts = " + cost);
    }
}
