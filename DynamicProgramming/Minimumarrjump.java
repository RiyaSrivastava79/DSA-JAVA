package DynamicProgramming;
import java.util.*;
public class Minimumarrjump {

    // Function to find the minimum number of jumps to reach the end
    public static int minJumps(int nums[]) {
        int n = nums.length;
        int dp[] = new int[n];

        // initialize dp array
        Arrays.fill(dp, -1);
        dp[n - 1] = 0; // no jump needed from last index

        // bottom-up calculation
        for (int i = n - 2; i >= 0; i--) {
            int steps = nums[i];
            int ans = Integer.MAX_VALUE;

            // try all possible jumps from position i
            for (int j = i + 1; j <= i + steps && j < n; j++) {
                if (dp[j] != -1) {
                    ans = Math.min(ans, dp[j] + 1);
                }
            }

            if (ans != Integer.MAX_VALUE) {
                dp[i] = ans;
            }
        }

        return dp[0];
    }

    public static void main(String args[]) {
        int nums[] = {2, 3, 1, 1, 4};
        System.out.println(minJumps(nums)); // Output: 2
    }
}