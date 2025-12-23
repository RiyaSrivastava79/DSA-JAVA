package DynamicProgramming;
import java.util.*;

public class Knapsacktable {

    // 0/1 Knapsack using Recursion + Memoization
    public static int knapsack(int val[], int wt[], int W, int n, int dp[][]) {
        // base case
        if (W == 0 || n == 0) {
            return 0;
        }

        // already computed value
        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n - 1] <= W) {
            int include = val[n - 1] + knapsack(val, wt, W - wt[n - 1], n - 1, dp);
            int exclude = knapsack(val, wt, W, n - 1, dp);
            dp[n][W] = Math.max(include, exclude);
        } else {
            dp[n][W] = knapsack(val, wt, W, n - 1, dp);
        }

        return dp[n][W];
    }

    // Utility to print 2D dp table
    public static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 0/1 Knapsack using Tabulation
    public static int knapsackTab(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                int v = val[i - 1];
                int w = wt[i - 1];

                if (w <= j) {
                    int include = v + dp[i - 1][j - w];
                    int exclude = dp[i - 1][j];
                    dp[i][j] = Math.max(include, exclude);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // print the table
        System.out.println("\nDP Table (Tabulation):");
        print(dp);

        return dp[n][W];
    }

    public static void main(String args[]) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;

        int dp[][] = new int[val.length + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans1 = knapsack(val, wt, W, val.length, dp);
        System.out.println("Recursion + Memoization Result: " + ans1);

        System.out.println("\nDP Table (Memoization):");
        print(dp);

        int ans2 = knapsackTab(val, wt, W);
        System.out.println("Tabulation Result: " + ans2);
    }
}
