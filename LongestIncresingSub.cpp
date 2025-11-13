int getResult(int index, int prevIndex, vector<int>& nums,
                  vector<vector<int>>& dp) {
        if (index == nums.size())
            return 0;
        if (dp[index][prevIndex + 1] != -1)
            return dp[index][prevIndex + 1];
        int notTake = getResult(index + 1, prevIndex, nums, dp);
        int take = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = 1 + getResult(index + 1, index, nums, dp);
        }
        return dp[index][prevIndex + 1] = max(take, notTake);
    }
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(n, -1));
        return getResult(0, -1, nums, dp);
    }
