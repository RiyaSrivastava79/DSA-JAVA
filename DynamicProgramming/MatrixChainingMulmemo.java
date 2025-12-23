package DynamicProgramming;
import java.util.*;
public class MatrixChainingMulmemo {
    // Recursive + Memoization
    public static int mcmMemo(int arr[], int i, int j, int dp[][]) {
        // Base case: single matrix → no multiplication
        if (i == j) {
            return 0;
        }

        // If already computed
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;

        // Try every possible partition between i and j
        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcmMemo(arr, i, k, dp);
            int cost2 = mcmMemo(arr, k + 1, j, dp);
            int cost3 = arr[i - 1] * arr[k] * arr[j];

            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }

        dp[i][j] = ans; // store and return
        return ans;
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 3}; // Dimensions of matrices
        int n = arr.length;

        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println("Minimum cost of multiplication: " + mcmMemo(arr, 1, n - 1, dp));
    }
}