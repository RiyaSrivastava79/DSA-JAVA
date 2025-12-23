package DynamicProgramming;
import java.util.*;
public class MatrixChainingMulTab {

    // Bottom-Up DP (Tabulation)
    public static int mcmTab(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];

        // Base case: single matrix → cost = 0
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // len = chain length (number of matrices in current segment)
        for (int len = 2; len < n; len++) {
            for (int i = 1; i <= n - len; i++) {
                int j = i + len - 1; // column index
                dp[i][j] = Integer.MAX_VALUE;

                // Try all possible partitions
                for (int k = i; k <= j - 1; k++) {
                    int cost1 = dp[i][k];
                    int cost2 = dp[k + 1][j];
                    int cost3 = arr[i - 1] * arr[k] * arr[j];

                    int finalCost = cost1 + cost2 + cost3;
                    dp[i][j] = Math.min(dp[i][j], finalCost);
                }
            }
        }

        // print dp table after computation
        print(dp);

        return dp[1][n - 1]; // min cost to multiply all matrices
    }

    // ✅ Proper DP array print method
    public static void print(int dp[][]) {
        System.out.println("\nDP Table:");
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (dp[i][j] == Integer.MAX_VALUE)
                    System.out.print("INF\t");
                else
                    System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 3}; // Dimensions of matrices
        System.out.println("Minimum cost of multiplication: " + mcmTab(arr));
    }
}