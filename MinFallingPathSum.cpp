int minFallingPathSum(vector<vector<int>> &vec, int n) {
    // Write your code here.
    vector<vector<int>>dp(n,vector<int>(n));
    for(int j=0;j<n;j++){
        dp[n-1][j]=vec[n-1][j];
    }
    for(int i=n-2;i>=0;i--){
        for(int j=0;j<n;j++){
            int  down=dp[i+1][j];
            int downLeft=j>0?dp[i+1][j-1]:1e9;
            int downRight=j<n-1?dp[i+1][j+1]:1e9;
            dp[i][j]=vec[i][j]+min({down,downLeft,downRight});
        }
    }
    int mini=*min_element(dp[0].begin(),dp[0].end());
    return mini;
}
