int maxProfit(vector<int>& prices, int fee) {
        vector<int> prev(2, 0), curr(2, 0);
        int n = prices.size();
        for (int i = n - 1; i >= 0; i--) {
            curr[0] = max(prev[0], -prices[i] + prev[1]);
            curr[1] = max(prev[1], prices[i] + prev[0] - fee);
            prev = curr;
        }

        return prev[0];
    }
