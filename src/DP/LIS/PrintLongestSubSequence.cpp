string findLCS(int n, int m,string &s1, string &s2){
vector<vector<int>>dp(n+1,vector<int>(m+1))	;
	for(int i=1;i<=n;i++){
	for(int j=1;j<=m;j++){
		if(s1[i-1]==s2[j-1]){
			dp[i][j]=1+dp[i-1][j-1];
		}
		else{
			dp[i][j]=max(dp[i-1][j],dp[i][j-1]);
		}
	}
	}
	string ans="";
	int l=n,h=m;
	while(h>0&&l>0){
		if(s1[l-1]==s2[h-1]){
			ans=s1[l-1]+ans;
			l--;
			h--;
		}
		else if(dp[l-1][h]>dp[l][h-1])l--;
		else h--;
	}
	return ans;
}
