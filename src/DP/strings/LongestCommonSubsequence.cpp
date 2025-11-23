int longestCommonSubsequence(string text1, string text2) {
        int m = text1.size(), n = text2.size();
        vector<vector<int>> dp(m, vector<int>(n, -1));
        return findResult(text1, text2, m - 1, n - 1, dp);
    }
    int findResult(string t1, string t2, int m, int n,
                   vector<vector<int>>& dp) {
                    
        if (m < 0 || n < 0)
            return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        if (t1[m] == t2[n])
            return dp[m][n] = 1 + findResult(t1, t2, m - 1, n - 1, dp);
        return dp[m][n] = max(findResult(t1, t2, m - 1, n, dp),
                              findResult(t1, t2, m, n - 1, dp));
    }
