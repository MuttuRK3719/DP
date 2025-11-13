 int maxProfit(vector<int>& prices) {
        int n=prices.size();
        vector<vector<vector<int>>>dp(n,vector<vector<int>>(2,vector<int>(3,-1)));
        return getProfit(0,prices,dp,1,2);
    }
    int getProfit(int index,vector<int> & prices,vector<vector<vector<int>>>&dp,int buy,int cap){
        if(index==prices.size()||cap==0) return 0;
        if(dp[index][buy][cap]!=-1) return dp[index][buy][cap];
        int profit=0;
        if(buy){
            profit=max(getProfit(index+1,prices,dp,1,cap),-prices[index]+getProfit(index+1,prices,dp,0,cap));
        }
        else {
            profit=max(getProfit(index+1,prices,dp,0,cap),prices[index]+getProfit(index+1,prices,dp,1,cap-1));
        }
        return dp[index][buy][cap]=profit;
    }

int maxProfit(vector<int>& prices) {
        int n=prices.size();
        vector<vector<vector<int>>>dp(n+1,vector<vector<int>>(2,vector<int>(3,0)));
        int profit=0;
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                    if(buy){
                        profit=max(dp[i+1][buy][cap],-prices[i]+dp[i+1][0][cap]);
                    }
                    else {
                        profit=max(dp[i+1][buy][cap],prices[i]+dp[i+1][1][cap-1]);
                    }
                    dp[i][buy][cap]=profit;
                }
            }
        }
        return dp[0][1][2];
        // return getProfit(0,prices,dp,1,2);
    }
