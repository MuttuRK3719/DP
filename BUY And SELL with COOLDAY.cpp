class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        vector<vector<int>> dp(n, vector<int>(2, -1));
        return getMax(prices, 0, dp, 0);
    }
    int getMax(vector<int>& prices, int index, vector<vector<int>>& dp,
               int buy) {
        if (index >= prices.size())
            return 0;
        if (dp[index][buy] != -1)
            return dp[index][buy];
        int profit = 0;
        if (buy == 0) {
            profit = max(getMax(prices, index + 1, dp, buy),
                         -prices[index] + getMax(prices, index + 1, dp, 1));
        } else {
            profit = max(getMax(prices, index + 1, dp, buy),
                         prices[index] + getMax(prices, index + 2, dp, 0));
        }
        return dp[index][buy] = profit;
    }
};


int maxProfit(vector<int>& prices) {
        int n = prices.size();
        vector<vector<int>> dp(n + 2, vector<int>(2, 0));
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if (buy == 0) {
                    profit = max(dp[i + 1][buy], -prices[i] + dp[i + 1][1]);
                } else {
                    profit = max(dp[i + 1][buy], prices[i] + dp[i + 2][0]);
                }
                dp[i][buy] = profit;
            }
        }
        return dp[0][0];
        // return getMax(prices, 0, dp, 0);
    }


int maxProfit(vector<int>& prices) {
        int n = prices.size();
        vector<int> front1(2),front2(2),curr(2);
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if (buy == 0) {
                    profit = max(front1[buy], -prices[i] + front1[1]);
                } else {
                    profit = max(front1[buy], prices[i] + front2[0]);
                }
                curr[buy] = profit;
            }
            front2=front1;
            front1=curr;
        }
        return front1[0];
        // return getMax(prices, 0, dp, 0);
    }
