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
