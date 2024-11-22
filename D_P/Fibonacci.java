import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 5;

        // Recursive approach
        System.out.println("Fibonacci (Recursive): " + fibbRC(n));

        // Top-down dynamic programming approach
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Fibonacci (Top-Down DP): " + fibbTD(n, dp));

        //Bottom-up
        System.out.println("Fibonacci (Bottom-Up): " + fibbBU(n));


    }

    // Top-down dynamic programming implementation
    private static int fibbTD(int n, int[] dp) {
        // Base cases
        if (n == 0 || n == 1) {
            return n;
        }

        // Use cached value if already calculated
        if (dp[n] != -1) {
            return dp[n];
        }

        // Calculate the Fibonacci number recursively and store it in dp
        dp[n] = fibbTD(n - 1, dp) + fibbTD(n - 2, dp);
        return dp[n];
    }

    // Recursive implementation
    private static int fibbRC(int n) {
        // Base cases
        if (n == 0 || n == 1) {
            return n;
        }

        // Recursive calls
        return fibbRC(n - 1) + fibbRC(n - 2);
    }

    // bottom-up dynamic programming implementation
    private static int fibbBU(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
            }
            
}       