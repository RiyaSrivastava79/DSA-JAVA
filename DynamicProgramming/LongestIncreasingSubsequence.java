package DynamicProgramming;

import java.util.*;

public class LongestIncreasingSubsequence {
    // LCS between two integer arrays
    public static int lcs(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        int dp[][] = new int[n + 1][m + 1];

        // Initialize dp array
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }

        // Fill dp array (bottom-up)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }

    // LIS using LCS (and HashSet)
    public static int lis(int arr1[]) {
        // Step 1: Put all elements into a HashSet (to remove duplicates)
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        // Step 2: Copy set elements into an array
        int arr2[] = new int[set.size()];
        int i = 0;
        for (int num : set) {
            arr2[i++] = num;
        }

        // Step 3: Sort arr2 (to get increasing order)
        Arrays.sort(arr2);

        // Step 4: LIS is LCS(arr1, arr2)
        return lcs(arr1, arr2);
    }

    public static void main(String args[]) {
        int arr[] = {50, 3, 10, 7, 40, 80};
        System.out.println("Length of LIS: " + lis(arr)); // Output: 4
    }
}