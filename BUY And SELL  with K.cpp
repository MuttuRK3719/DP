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

int maxProfit(int k, vector<int>& prices) {
        int n = prices.size();
        vector<vector<int>> dp(n+1, vector<int>(2*k+1, 0));
        for(int i=n-1;i>=0;i--){
            int profit=0;
            for(int tran=2*k-1;tran>=0;tran--){
                if(tran%2==0){
                    profit=max(dp[i+1][tran],-prices[i]+dp[i+1][tran+1]);
                }
                else {
                    profit=max(dp[i+1][tran],prices[i]+dp[i+1][tran+1]);
                }
                dp[i][tran]=profit;
            }
        }
        return dp[0][0];
        // return getMax(prices, 0,2*k, 0, dp);
    }

int maxProfit(int k, vector<int>& prices) {
        int n = prices.size();
        vector<int> prev(2*k+1),curr(2*k+1);
        for(int i=n-1;i>=0;i--){
            int profit=0;
            for(int tran=2*k-1;tran>=0;tran--){
                if(tran%2==0){
                    profit=max(prev[tran],-prices[i]+prev[tran+1]);
                }
                else {
                    profit=max(prev[tran],prices[i]+prev[tran+1]);
                }
                curr[tran]=profit;
            }
            prev=curr;
        }
        return prev[0];
        // return getMax(prices, 0,2*k, 0, dp);
    }
