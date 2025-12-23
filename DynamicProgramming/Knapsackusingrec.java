package DynamicProgramming;
import java.util.*;

public class Knapsackusingrec {

    public static int knapsack(int val[], int wt[], int W, int n, int dp[][]) {
        // base case
        if (W == 0 || n == 0) {
            return 0;
        }
        if(dp[n][W] != -1){
            return dp[n][W];
        }

        // if current item's weight is less than or equal to remaining capacity
        if (wt[n - 1] <= W) {
            // include
            int ans1 = val[n - 1] + knapsack(val, wt, W - wt[n - 1], n - 1, dp);
            // exclude
            int ans2 = knapsack(val, wt, W, n - 1, dp);
            dp[n][W] =  Math.max(ans1, ans2);
            return dp[n][W];
        } else {
            // if current item cannot be included
            dp[n][W] =  knapsack(val, wt, W, n - 1, dp);
            return dp[n][W];
        }
    }

    public static void print(int dp[][]){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 0/1 Knapsack using Tabulation
    public static int knapsackTab(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];

        // Base case initialization
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0; // 0 capacity → 0 profit
        }
        for (int j = 0; j <= W; j++) {
            dp[0][j] = 0; // 0 items → 0 profit
        }

        // Build dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                int v = val[i - 1]; // value of current item
                int w = wt[i - 1];  // weight of current item

                if (w <= j) { // valid — can include item
                    int incProfit = v + dp[i - 1][j - w];
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else { // invalid — can’t include item
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String args[]) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
        int dp[][] = new int[val.length+1][W+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        // System.out.println(knapsack(val, wt, W, val.length, dp));
        System.out.println(knapsackTab(val, wt, W));

    }
}