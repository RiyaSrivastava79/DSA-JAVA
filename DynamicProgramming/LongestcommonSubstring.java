package DynamicProgramming;
import java.util.*;
public class LongestcommonSubstring {

    public static int longestCommonSubstring(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        int ans = 0;

        // initialize dp (0th row and 0th column already default 0)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // if characters match
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0; // reset because substring must be contiguous
                }
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        String str1 = "ABCDE";
        String str2 = "ABGCE";
        System.out.println("Length of Longest Common Substring: " + longestCommonSubstring(str1, str2));
    }
}