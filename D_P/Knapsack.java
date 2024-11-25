import java.util.*;

public class Knapsack {
    public int maxValue(int[] wt, int[] val, int cap) {
        if (wt == null || val == null || wt.length == 0 || val.length == 0 || wt.length != val.length) {
            return 0;
        }

        int n = wt.length;
        int[] dp = new int[cap + 1];

        for (int i = 0; i < n; i++) {
            for (int j = cap; j >= wt[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - wt[i]] + val[i]);
            }
        }

        return dp[cap];
    }

    public static void main(String[] args) {
        Knapsack test = new Knapsack();
        int[] weights = {1,2,3,2,2};  // Example weights
        int[] values = {8,4,0,5,3};// Example values
        int capacity = 4; // Example capacity

        int maxValue = test.maxValue(weights, values, capacity);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}