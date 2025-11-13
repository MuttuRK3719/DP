int findNumberOfLIS(vector<int>& nums) {
        int maxi = 0;
        int n = nums.size();
        vector<int> dp(n, 1), count(n, 1);
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[prev] < nums[i] && dp[prev] + 1 > dp[i]) {
                    dp[i] = dp[prev] + 1;
                    count[i] = count[prev];
                } else if (nums[prev] < nums[i] && dp[prev] + 1 == dp[i]) {
                    count[i] += count[prev];
                }
            }
            maxi = max(maxi, dp[i]);
        }
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxi)
                c += count[i];
        }
        return c;
    }
