package DynamicProgramming;
import java.util.*;
public class LCSusingmemo {

    // Memoization version
    public static int lcs2(String str1, String str2, int n, int m, int dp[][]) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) { // same char
            dp[n][m] = 1 + lcs2(str1, str2, n - 1, m - 1, dp);
        } else { // different char
            int ans1 = lcs2(str1, str2, n - 1, m, dp);
            int ans2 = lcs2(str1, str2, n, m - 1, dp);
            dp[n][m] = Math.max(ans1, ans2);
        }

        return dp[n][m];
    }

    // Main method
    public static void main(String args[]) {
        String str1 = "abcdge";
        String str2 = "abedg";  // LCS = "abdg", length = 4

        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n + 1][m + 1];

        // Initialize dp with -1
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println("LCS length (Memoization): " + lcs2(str1, str2, n, m, dp));
    }
}