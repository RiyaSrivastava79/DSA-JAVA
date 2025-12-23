package DynamicProgramming;
import java.util.*;

public class  targetSumSubset{

    public static boolean targetSumSubset(int arr[], int sum) {
        int n = arr.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];

        // Initialization
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true; // sum = 0 can always be made (by taking no elements)
        }

        // Build DP table
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                int v = arr[i - 1];

                // Exclude
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                }
                // Include (only if value <= target)
                else if (v <= j && dp[i - 1][j - v]) {
                    dp[i][j] = true;
                }
            }
        }

        // Print DP table (optional)
        print(dp);

        return dp[n][sum];
    }

    public static void print(boolean dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int arr[] = {4, 2, 7, 1, 3};
        int sum = 10;
        System.out.println("Target sum subset exists: " + targetSumSubset(arr, sum));
    }
}