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
