class Solution {
public:
    int ninjaTraining(vector<vector<int>>& matrix) {
        int n=matrix.size();
        vector<vector<int>> dp(n,vector<int>(4,-1));
        return find(n-1,3,matrix,dp);
    }
    int find(int day,int last,vector<vector<int>>& matrix,vector<vector<int>>& dp){
        if(dp[day][last]!=-1){
            return dp[day][last];
        }
        if(day==0){
            int maxi=0;
            for(int i=0;i<3;i++){
                if(i!=last){
                    maxi=max(maxi,matrix[0][i]);
                }
            }
            return dp[day][last]=maxi;
        }
        int maxi=0;
        for(int i=0;i<3;i++){
            if(i!last){
            int activity=matrix[day][i]+find(day-1,i,matrix,dp);
            maxi=max(maxi,activity);
            }
        }
        return dp[day][last]=maxi;
    }
};
