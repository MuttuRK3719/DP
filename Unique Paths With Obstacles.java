//recursion
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

   //tabulation   
    int uniquePathsWithObstacles1(vector<vector<int>>& obstacleGrid) {
        int m = obstacleGrid.size(), n = obstacleGrid[0].size();
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
            return 0;
        vector<vector<int>> dp(m, vector<int>(n));
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0 || obstacleGrid[i][j] == 1)
                    continue;
                if (i > 0)
                    dp[i][j] = dp[i - 1][j];
                if (j > 0)
                    dp[i][j] += dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
        //  return f(m-1,n-1,obstacleGrid,dp);
    }

