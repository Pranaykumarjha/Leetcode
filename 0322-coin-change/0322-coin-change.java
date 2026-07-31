class Solution {

    int[] dp;

    public int coinChange(int[] coins, int amount) {

        dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        int ans = solve(amount, coins);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int solve(int amount, int[] coins) {

        if (amount == 0)
            return 0;

        if (amount < 0)
            return Integer.MAX_VALUE;

        if (dp[amount] != -1)
            return dp[amount];

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {

            int res = solve(amount - coin, coins);

            if (res != Integer.MAX_VALUE)
                minCoins = Math.min(minCoins, 1 + res);
        }

        dp[amount] = minCoins;

        return dp[amount];
    }
}