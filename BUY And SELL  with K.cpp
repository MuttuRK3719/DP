int getMax(vector<int>& prices, int index, int k, int trans,
               vector<vector<int>>& dp) {
        if (index == prices.size() || trans == k)
            return 0;
        if (dp[index][trans] != -1)
            return dp[index][trans];
        int profit = 0;
        if (trans % 2 == 0) {
            profit = max(getMax(prices, index + 1, k, trans, dp),
                         -prices[index] +
                             getMax(prices, index + 1, k, trans + 1, dp));
        }
        else {
            profit = max(getMax(prices, index + 1, k, trans, dp),
                    prices[index] + getMax(prices, index+1, k, trans + 1, dp));
        }
        return dp[index][trans] = profit;
    }
    int maxProfit(int k, vector<int>& prices) {
        int n = prices.size();
        vector<vector<int>> dp(n, vector<int>(2*k, -1));
        return getMax(prices, 0,2*k, 0, dp);
    }
