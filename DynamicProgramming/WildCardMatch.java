package DynamicProgramming;
public class WildCardMatch {

    // Function to check if string s matches pattern p
    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean dp[][] = new boolean[n + 1][m + 1];

        // Empty string matches empty pattern
        dp[0][0] = true;

        // If pattern starts with '*', it can match empty string
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Bottom-up DP
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                // Case 1: Current chars match OR pattern has '?'
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                // Case 2: Pattern has '*'
                else if (p.charAt(j - 1) == '*') {
                    // '*' can match empty (dp[i][j-1]) OR any char (dp[i-1][j])
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }

                // Case 3: No match
                else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }

    // Driver code
    public static void main(String args[]) {
        String s = "baaabab";
        String p = "ba**ab";

        System.out.println(isMatch(s, p));  // Expected output: true
    }
}