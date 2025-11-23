    int countSubSet(vector<int>&arr,int target,vector<vector<int>>& dp,int index){
           if(index == 0){
            if(target == 0 && arr[0] == 0) return 2;
            if(target == 0) return 1;               
            if(arr[0] == target) return 1;
            return 0;
        }
        if(dp[index][target]!=-1)return dp[index][target];
        int notTake=countSubSet(arr,target,dp,index-1);
        int take=0;
        if(arr[index]<=target){
            take=countSubSet(arr,target-arr[index],dp,index-1);
        }
        return dp[index][target]=take+notTake;
    }

int perfectSum(vector<int>& arr, int target) {
        // code here
        int n=arr.size();
        vector<vector<int>>dp(n,vector<int>(target+1));
        // return countSubSet(arr,target,dp,n-1);
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        int MOD=1e7;
        if(arr[0]<=target)dp[0][arr[0]]=1;
         if(arr[0]==0)dp[0][0]=2;
        for(int i=1;i<n;i++){
            for(int j=0;j<=target;j++){
                int take=dp[i-1][j];
                int notTake=0;
                if(arr[i]<=j){
                    notTake=dp[i-1][j-arr[i]];
                }
                dp[i][j]=take+notTake;
            }
            if(arr[i] == 0)
            dp[i][0] = (dp[i-1][0] * 2);
        }
        return dp[n-1][target];
    }

int perfectSum(vector<int>& arr, int target) {
        int n=arr.size();
        vector<int>prev(target+1);
        if(arr[0]<=target)prev[arr[0]]=1;
        if(arr[0]==0)prev[0]=2;
        else prev[0]=1;
        
        for(int i=1;i<n;i++){
            vector<int> curr(target+1);
            for(int j=0;j<=target;j++){
                int take=prev[j];
                int notTake=0;
                if(arr[i]<=j){
                    notTake=prev[j-arr[i]];
                }
                curr[j]=take+notTake;
            }
            if(arr[i]==0){
                curr[0]=prev[0]*2;
            }
            else curr[0]=prev[0];
            
            prev=curr;
    }
    return prev[target];
    }
