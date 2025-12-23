package DynamicProgramming;
import java.util.*;
public class RodCutting {

    // Rod Cutting Problem (same as Unbounded Knapsack)
    // length[] -> available piece lengths
    // price[]  -> price of each piece
    // totRod   -> total rod length
    public static int rodCutting(int length[], int price[], int totRod) {
        int n = price.length;
        int dp[][] = new int[n + 1][totRod + 1];

        // Build DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totRod; j++) {
                if (length[i - 1] <= j) { 
                    // include or exclude
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                } else {
                    // cannot include
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][totRod];
    }

    public static void main(String args[]) {
        int length[] = {1, 2, 3, 4, 5, 6, 7, 8}; // piece lengths
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20}; // prices
        int totRod = 8;

        System.out.println("Maximum Profit: " + rodCutting(length, price, totRod));
    }
}