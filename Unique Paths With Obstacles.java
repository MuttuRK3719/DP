   int f(int m, int n, vector<vector<int>>& grid, vector<vector<int>>& dp) {
        if (m == 0 && n == 0)
            return 1;
        if (m < 0 || n < 0 || grid[m][n] == 1)
            return 0;
        if (dp[m][n] != -1)
            return dp[m][n];
        int down = f(m - 1, n, grid, dp);
        int left = f(m, n - 1, grid, dp);
        return dp[m][n] = down + left;
    }
