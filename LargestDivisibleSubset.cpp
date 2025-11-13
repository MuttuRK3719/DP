vector<int> largestDivisibleSubset(vector<int>& nums) {
        int maxi = 0, lastIndex = 0;
        int n = nums.size();
        vector<int> dp(n, 1), hash(n);
        sort(nums.begin(), nums.end());
        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] % nums[prev] == 0 && dp[prev] + 1 > dp[i]) {
                    dp[i] = dp[prev] + 1;
                    hash[i] = prev;
                }
            }
            if (dp[i] > maxi) {
                maxi = dp[i];
                lastIndex = i;
            }
        }
        vector<int> temp;
        while (hash[lastIndex] != lastIndex) {
            temp.push_back(nums[lastIndex]);
            lastIndex = hash[lastIndex];
        }
        temp.push_back(nums[lastIndex]);
        reverse(temp.begin(), temp.end());
        return temp;
    }
