    public static int frogJump(int[] heights) {
        int[] dp = new int[heights.length + 1];
        Arrays.fill(dp, -1);
        return frogJump(heights, dp, dp.length - 2);
    }

    public static int frogJump(int[] h, int[] dp, int index) {
        if (index <= 0) return 0;
        if (dp[index] != -1) return dp[index];
        int left = frogJump(h, dp, index - 1) + Math.abs(h[index] - h[index - 1]);
        int right = Integer.MAX_VALUE;
        if (index > 1)
            right = frogJump(h, dp, index - 2) + Math.abs(h[index] - h[index - 2]);
        return dp[index] = Math.min(left, right);
    }
