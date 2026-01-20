package DynamicProgramming;

public class CoinChange {

    public static int coinChange(int coins[], int sum) {
        int n = coins.length;
        int dp[][] = new int[n + 1][sum + 1];

        // Initialize: if sum = 0, only 1 way (choose no coins)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i - 1] <= j) {
                    // include + exclude
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    // exclude only
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String args[]) {
        int coins[] = {1, 2, 3};
        int sum = 4;
        System.out.println(coinChange(coins, sum)); // Output = 4
    }
}