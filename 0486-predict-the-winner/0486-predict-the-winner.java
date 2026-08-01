import java.util.Arrays;

class Solution {

    private int[] nums;
    private int[][] dp;

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        this.nums = nums;

        dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        return dfs(0, n - 1) >= 0;
    }

    private int dfs(int left, int right) {
        if (left == right)
            return nums[left];

        if (dp[left][right] != Integer.MIN_VALUE)
            return dp[left][right];

        int pickLeft = nums[left] - dfs(left + 1, right);
        int pickRight = nums[right] - dfs(left, right - 1);

        return dp[left][right] = Math.max(pickLeft, pickRight);
    }
}