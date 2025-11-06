 int minFallingPathSum(vector<vector<int>>& matrix) {
        int m=matrix.size(),n=matrix[0].size();
        vector<vector<int>> dp(m,vector<int>(n,-1));
        int ans=1e8;
        for(int i=0;i<n;i++){
            ans=min(ans,minVal(0,i,matrix,dp));
        }
        return ans;
    }
    int minVal(int row,int col,vector<vector<int>>&matrix,vector<vector<int>>&dp){
        if(col<0||col>=matrix[0].size()) return 1e8;
        if(row==matrix.size()-1) return matrix[row][col];
        if(dp[row][col]!=-1) return dp[row][col];
        int leftDown=matrix[row][col]+minVal(row+1,col-1,matrix,dp);
        int rightDown=matrix[row][col]+minVal(row+1,col+1,matrix,dp);
        int down=matrix[row][col]+minVal(row+1,col,matrix,dp);
        int ans=min(leftDown,min(rightDown,down));
        return dp[row][col]=ans;
    }
