class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int[] dp = new int[envelopes.length];
        int len = 0;

        for (int[] envelope : envelopes) {
            int h = envelope[1];
            int i = Arrays.binarySearch(dp, 0, len, h);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = h;
            if (i == len) {
                len++;
            }
        }

        return len;
    }
}