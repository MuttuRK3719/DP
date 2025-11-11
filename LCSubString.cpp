int LCSubStr(string &str1, string &str2)
{
    int n=str1.size(),m=str2.size();

    vector<vector<int>>dp(n+1,vector<int>(m+1));
    int ans=0;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            if(str1[i-1]==str2[j-1]){
                dp[i][j]=1+dp[i-1][j-1];
                ans=max(ans,dp[i][j]);
            }
            // else dp[i][j]=0;
        }
    }

    return ans;
    // Write your code here

}


int LCSubStr(string &str1, string &str2)
{
    int n=str1.size(),m=str2.size();

    vector<int>prev(m+1);
    int ans=0;
    for(int i=1;i<=n;i++){
        vector<int>curr(m+1);
        for(int j=1;j<=m;j++){
            if(str1[i-1]==str2[j-1]){
                curr[j]=1+prev[j-1];
                ans=max(ans,curr[j]);
            }
            else curr[j]=0;
        }
        prev=curr;
    }

    return ans;
    // Write your code here

}
