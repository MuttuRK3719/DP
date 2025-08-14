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
      public static int tabulationMethod(int[] heights) {
        int[] dp = new int[heights.length];
        for (int i = 1; i < heights.length; i++) {
            int fs = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int ss = Integer.MAX_VALUE;
            if (i > 1) ss = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            dp[i] = Math.min(fs, ss);
        }
        return dp[dp.length - 1];
    }
    public static int spaceOptimization(int []heights){
        int prev1=0;
        int prev2=0;
        for (int i = 1; i < heights.length; i++) {
            int fs=prev1+Math.abs(heights[i]-heights[i-1]);
            int ss=Integer.MAX_VALUE;
            if(i>1) ss=prev2+Math.abs(heights[i]-heights[i-2]);
            prev2=prev1;
            prev1=Math.min(fs,ss);
        }
        return prev1;
    }
