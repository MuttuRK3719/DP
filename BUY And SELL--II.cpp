

int getMaxProfit(int index, int buy, vector<int>& prices,
                     vector<vector<int>>& dp) {
        if (index == prices.size())
            return 0;
        if (dp[index][buy] != -1)
            return dp[index][buy];
        int profit = 0;
        if (buy) {
            profit =
                max(getMaxProfit(index + 1, 1, prices, dp),
                    -prices[index] + getMaxProfit(index + 1, 0, prices, dp));
        } else
            profit =
                max(getMaxProfit(index + 1, 0, prices, dp),
                    prices[index] + getMaxProfit(index + 1, 1, prices, dp));
        return dp[index][buy] = profit;
    }

int maxProfit(vector<int>& prices) {
        int n = prices.size();
        vector<int> prev(2),curr(2);
        int profit = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) {
                    profit = max(prev[0], -prices[i] + prev[1]);
                } else {
                    profit = max(prev[1], prices[i] +prev[0]);
                }
                curr[buy] = profit;
            }
            prev=curr;
        }
        return prev[0];
        // return getMaxProfit(0,1,prices,dp);
    }

int maxProfit(vector<int>& prices) {
        int n = prices.size();
        vector<vector<int>> dp(n + 1, vector<int>(2));
        int profit = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) {
                    profit = max(dp[i + 1][0], -prices[i] + dp[i + 1][1]);
                } else {
                    profit = max(dp[i + 1][1], prices[i] + dp[i + 1][0]);
                }
                dp[i][buy] = profit;
            }
        }
        return dp[0][0];
        // return getMaxProfit(0,1,prices,dp);
    }
