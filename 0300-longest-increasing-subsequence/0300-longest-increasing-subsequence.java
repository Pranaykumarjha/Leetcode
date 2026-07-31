class Solution {

    int[] dp;

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        dp = new int[n];
        Arrays.fill(dp, -1);

        int ans = 0;

       
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, solve(i, nums));
        }

        return ans;
    }

    private int solve(int i, int[] nums) {

        if (dp[i] != -1)
            return dp[i];

        int maxLength = 1;

        for (int j = i + 1; j < nums.length; j++) {

            if (nums[j] > nums[i]) {
                maxLength = Math.max(maxLength, 1 + solve(j, nums));
            }
        }

        dp[i] = maxLength;

        return dp[i];
    }
}