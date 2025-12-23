package DynamicProgramming;
import java.util.*;
public class MinimumPartition {

    // O(n * sum) time
    public static int minPartition(int arr[]) {
        int n = arr.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        int W = sum / 2;
        boolean dp[][] = new boolean[n + 1][W + 1];

        // Initialization
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true; // sum = 0 is always possible
        }

        // Bottom-up DP (Subset Sum)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Find the largest j <= W where dp[n][j] is true
        int sum1 = 0;
        for (int j = W; j >= 0; j--) {
            if (dp[n][j]) {
                sum1 = j;
                break;
            }
        }

        int sum2 = sum - sum1;
        return Math.abs(sum2 - sum1);
    }

    public static void main(String args[]) {
        int nums[] = {1, 6, 11, 5};
        System.out.println("Minimum subset sum difference: " + minPartition(nums));
    }
}
