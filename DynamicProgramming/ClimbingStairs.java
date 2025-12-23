package DynamicProgramming;
public class ClimbingStairs {

    public static int countWays(int n) {
        if (n == 0) {   // base case: one way to stay at 0
            return 1;
        }
        if (n < 0) {    // base case: no way to go below 0
            return 0;
        }
        // recursive relation: sum of previous two steps
        return countWays(n - 1) + countWays(n - 2);
    }

    public static void main(String args[]) {
        int n = 5; // For n=3 -> 3 ways, n=4 -> 5 ways, n=5 -> 8 ways
        System.out.println(countWays(n));
    }
}