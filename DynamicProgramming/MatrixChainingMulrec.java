package DynamicProgramming;

import java.util.*;

public class MatrixChainingMulrec {

    // Recursive function for Matrix Chain Multiplication
    public static int mcm(int arr[], int i, int j) {
        // Base case: only one matrix
        if (i == j) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        // Try all possible partitions
        for (int k = i; k < j; k++) {
            int cost1 = mcm(arr, i, k);        // cost of multiplying left side
            int cost2 = mcm(arr, k + 1, j);    // cost of multiplying right side
            int cost3 = arr[i - 1] * arr[k] * arr[j]; // cost of multiplying two resulting matrices

            int finalCost = cost1 + cost2 + cost3;

            ans = Math.min(ans, finalCost);
        }

        return ans; // minimum cost
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 3}; // Dimensions of matrices
        int n = arr.length;

        // We start from matrix 1 to n-1
        System.out.println("Minimum cost of Matrix Chain Multiplication: " + mcm(arr, 1, n - 1));
    }
}