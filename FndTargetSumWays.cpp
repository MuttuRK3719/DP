int findTargetSumWays(vector<int>& nums, int target) {
        int totalSum = 0;
        for (int ele : nums) {
            totalSum += ele;
        }
        int s = totalSum + target;
        if (s % 2 != 0 || s < 0)
            return 0;
        s /= 2;
        return countSubSet(nums, s);
    }
    int countSubSet(vector<int>& nums, int target) {
        vector<int> prev(target + 1, 0);
        prev[0] = 1;
        if (nums[0] <= target)
            prev[nums[0]] = 1;
        if (nums[0] == 0)
            prev[0] = 2;
        for (int i = 1; i < nums.size(); i++) {
            vector<int> curr(target + 1);
            for (int tar = 1; tar <= target; tar++) {
                int notTake = prev[tar];
                int take = 0;
                if (tar >= nums[i]) {
                    take = prev[tar - nums[i]];
                }
                curr[tar] = take + notTake;
            }
            if (nums[i] == 0) {
                curr[0] = prev[0] * 2;
            } else
                curr[0] = prev[0];
            prev = curr;
        }
        return prev[target];
    }
