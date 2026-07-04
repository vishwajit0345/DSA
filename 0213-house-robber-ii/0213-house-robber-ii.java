import java.util.Arrays;

class Solution {

    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return nums[0];

        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int ans1 = solve(nums, 0, n - 2, dp1);

        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int ans2 = solve(nums, 1, n - 1, dp2);

        return Math.max(ans1, ans2);
    }

    private int solve(int[] nums, int index, int end, int[] dp) {
        if (index > end)
            return 0;

        if (dp[index] != -1)
            return dp[index];

        int take = nums[index] + solve(nums, index + 2, end, dp);
        int notTake = solve(nums, index + 1, end, dp);

        return dp[index] = Math.max(take, notTake);
    }
}