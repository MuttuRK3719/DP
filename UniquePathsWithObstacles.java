Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

Input: obstacleGrid = [[0,1],[0,0]]
Output: 1

public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1||obstacleGrid[m-1][n-1]==1) return 0;
        return countPath(obstacleGrid, m - 1, n - 1, new int[m][n]);
    }

    int countPath(int[][] oG, int m, int n, int[][] dp) {
        if (m < 0 || n < 0)
            return 0;
        if (m == 0 && n == 0)
            return 1;
        if (oG[m][n] == 1)
            return 0;
        if (dp[m][n] != 0)
            return dp[m][n];
        return dp[m][n] = countPath(oG, m - 1, n, dp) + countPath(oG, m, n - 1, dp);
    }
