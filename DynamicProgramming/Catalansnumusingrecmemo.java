package DynamicProgramming;
import java.util.*;
public class Catalansnumusingrecmemo {

    // Recursive version
    public static int catalanRec(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int ans = 0; // Cn
        for (int i = 0; i < n; i++) {
            ans += catalanRec(i) * catalanRec(n - 1 - i);
        }

        return ans;
    }

    // Memoization version
    public static int catalanMem(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += catalanMem(i, dp) * catalanMem(n - 1 - i, dp);
        }

        dp[n] = ans;
        return dp[n];
    }

    // 🔹 Driver Code
    public static void main(String args[]) {
        int n = 4;

        System.out.println("Catalan (Recursive): " + catalanRec(n));

        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Catalan (Memoized): " + catalanMem(n, dp));
    }
}
