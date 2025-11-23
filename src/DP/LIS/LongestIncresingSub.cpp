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

int lengthOfLISTabulation(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> dp(n + 1, vector<int>(n + 1));
        // return getResult(0, -1, nums, dp);
        for (int i = n - 1; i >= 0; i--) {
            for (int prev = i - 1; prev >= -1; prev--) {
                int len = dp[i + 1][prev + 1];
                if (prev == -1 || nums[prev] < nums[i]) {
                    len = max(len, 1 + dp[i + 1][i + 1]);
                }
                dp[i][prev + 1] = len;
            }
        }
        return dp[0][0];
    }


    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(n, -1));
        return getResult(0, -1, nums, dp);
    }


int lengthOfLIS(vector<int>& nums) {
        vector<int> temp;
        temp.push_back(nums[0]);
        int len = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] > temp.back()) {
                temp.push_back(nums[i]);
                len++;
            } else {
                int index = lower_bound(temp.begin(), temp.end(), nums[i]) -
                            temp.begin();
                temp[index] = nums[i];
            }
        }
        return temp.size();
    }
