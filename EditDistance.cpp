int f(string s1,string s2,int i,int j,vector<vector<int>>&dp){
    if(i<0) return j+1;
    if(j<0) return i+1;
    if(dp[i][j]!=-1) return dp[i][j];
    if(s1[i]==s2[j]) return dp[i][j]= f(s1,s2,i-1,j-1,dp);
    else {
        return dp[i][j]=1+min(f(s1,s2,i-1,j,dp),min(f(s1,s2,i,j-1,dp),f(s1,s2,i-1,j-1,dp)));
    }
}

int editDistance(string str1, string str2)
{
    //write you code here
    int m=str1.size(),n=str2.size();
    vector<vector<int>>dp(m+1,vector<int>(n+1));
    for(int j=0;j<=n;j++){
        dp[0][j]=j;
    }
    for(int i=0;i<=m;i++){
        dp[i][0]=i;
    }
    for(int i=1;i<=m;i++){
        for(int j=1;j<=n;j++){
            if(str1[i-1]==str2[j-1])dp[i][j]=dp[i-1][j-1];
            else {
                dp[i][j]=1+min(dp[i-1][j],min(dp[i][j-1],dp[i-1][j-1]));
            }
        }
    }
    return dp[m][n];


    // return f(str1,str2,m-1,n-1,dp);

}
