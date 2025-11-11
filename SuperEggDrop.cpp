class Solution {
public:
    int superEggDrop(int k, int n) {
        vector<vector<int>>dp(k+1,vector<int>(n+1,-1));
        return superEggDropBinary(k,n,dp);
    }
    int superEggDropBinary(int k,int n, vector<vector<int>> &dp){
        if(dp[k][n]!=-1) return dp[k][n];
        if(n<=1) return n;
        if(k==1) return n;
        int low=1, high=n;
        int ans=INT_MAX;
        while(low<=high){
            int mid=low+(high-low)/2;
            int breaks=superEggDropBinary(k-1,mid-1,dp);
            int notBreak=superEggDropBinary(k,n-mid,dp);
            int temp=1+max(breaks,notBreak);
            if(breaks<notBreak){
                low=mid+1;
            }
            else high=mid-1;
            ans=min(ans,temp);
        }
       return dp[k][n]=ans;
    }
    int superEggDropTabulation(int k, int n) {
        vector<vector<int>>dp(k+1,vector<int>(n+1,0));
        for(int i=0;i<=k;i++){
            dp[i][0]=0;
            dp[i][1]=1;
        }
        for(int j=1;j<=n;j++){
            dp[1][j]=j;
        }
        for(int i=2;i<=k;i++){
            for(int j=2;j<=n;j++){
                dp[i][j]=INT_MAX;
                for(int x=1;x<=j;x++){
                        int res=1+max(dp[i-1][x-1],dp[i][j-x]);
                        dp[i][j]=min(res,dp[i][j]);
                }
            }
        }
        return dp[k][n];
        // return findMin(k,n,dp);
    }
    int findMin(int egg,int floor,vector<vector<int>>&dp){
    if(dp[egg][floor]!=-1) return dp[egg][floor];
    if(floor==1||floor==0) return floor;
    if(egg==1) return floor;  
    int ans=INT_MAX; 
    for(int x=1;x<=floor;x++){
    int break1=findMin(egg-1,x-1,dp);
    int notBreak=findMin(egg,floor-x,dp);
    int worst=1+max(break1,notBreak);
    ans=min(ans,worst);
    }
    return dp[egg][floor]=ans;
    }
};
