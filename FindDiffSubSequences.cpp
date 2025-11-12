int numDistinct(string s, string t) {
        int m = s.size(), n = t.size();
        vector<vector<int>> dp(m, vector<int>(n, -1));
        return findRes(s, t, m - 1, n - 1, dp);
    }
    int findRes(string& s, string& t, int m, int n, vector<vector<int>>& dp) {
        if (n < 0)
            return 1;
        if (m < 0)
            return 0;
        if (dp[m][n] != -1)
            return dp[m][n];
        if (s[m] == t[n])
            return dp[m][n] = findRes(s, t, m - 1, n - 1, dp) +
                              findRes(s, t, m - 1, n, dp);
        else
            return dp[m][n] = findRes(s, t, m - 1, n, dp);
    }


int numDistinct(string s, string t) {
        int m = s.size(), n = t.size();
        vector<vector<double >> dp(m+1, vector<double>(n+1));
        for(int j=0;j<=m;j++){
            dp[j][0]=1;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s[i-1]==t[j-1])dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                else dp[i][j]=dp[i-1][j];
            }
        }
        return (int)dp[m][n];
        // return findRes(s, t, m - 1, n - 1, dp);
    }
