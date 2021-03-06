package q714;

/**
 * @author zhangnan
 * @date 2021/5/18 10:28
 */
public class Solution {

    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2);
    }
}
