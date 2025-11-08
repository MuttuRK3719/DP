int minimumDifference1(vector<int>& nums) {
        int totalSum = 0;
        for (int ele : nums)
            totalSum += ele;
        int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(totalSum + 1, -1));
        int mini = 1e8;
        for (int i = 0; i <= totalSum; i++) {
            subSetSum(n - 1, i, nums, dp);
        }
        for (int i = 0; i <= totalSum; i++) {
            if (dp[n - 1][i] == true) {
                mini = min(mini, abs(i - (totalSum - i)));
            }
        }
        return mini;
    }
    bool subSetSum(int index, int sum, vector<int>& arr,
                   vector<vector<int>>& dp) {
        if (sum == 0)
            return true;
        if (index == 0) {
            return dp[index][sum] = arr[0] == sum;
        }
        if (dp[index][sum] != -1)
            return dp[index][sum];
        bool notTake = subSetSum(index - 1, sum, arr, dp);
        bool take = false;
        if (arr[index] <= sum) {
            take = subSetSum(index - 1, sum - arr[index], arr, dp);
        }
        return dp[index][sum] = take || notTake;
    }
