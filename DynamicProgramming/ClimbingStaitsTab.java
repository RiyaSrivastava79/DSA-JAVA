package DynamicProgramming;
import java.util.*;

public class ClimbingStaitsTab {
    // Tabulation O(n)
    public static int countWaysTab(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1; // base case

        for (int i = 1; i <= n; i++) {
            int step1 = dp[i - 1];
            int step2 = (i >= 2) ? dp[i - 2] : 0;
            dp[i] = step1 + step2;
        }

        return dp[n];
    }

    public static void main(String args[]) {
        int n = 5; // n=3 -> 3, n=4 -> 5, n=5 -> 8

        int ways[] = new int[n + 1];
        Arrays.fill(ways, -1);
        System.out.println("Tabulation result: " + countWaysTab(n));
    }
}