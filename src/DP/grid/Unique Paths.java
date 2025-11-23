https://leetcode.com/problems/unique-paths/

int uniquePaths(int m,int n){
        int [][]dp=new int[m][n];
        return uniquePaths(m-1,n-1,dp);
    }
    public int uniquePaths(int m, int n,int[][]dp) {
        if (m == 0 || n == 0)
            return 1;
            if(dp[m][n]!=0) return dp[m][n];
            dp[m][n]= uniquePaths(m - 1, n,dp)+uniquePaths(m,n-1,dp);
            return dp[m][n];
    }
