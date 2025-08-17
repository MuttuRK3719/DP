https://leetcode.com/problems/word-break/
public boolean wordBreak(String s, List<String> wordDict) {
     boolean []dp=new boolean[s.length()+1];
     HashSet<String> words=new HashSet<>(wordDict);
     dp[0]=true;
     int maxLength=0;
     for(String s1:wordDict){
        if(s1.length()>maxLength)maxLength=s1.length();
     }
     for(int i=1;i<dp.length;i++){
        for(int j=i-1;j>=Math.max(0,i-maxLength);j--){
            if(dp[j]&&words.contains(s.substring(j,i))){
                dp[i]=true;
                break;
            }
        }
     }   
     return dp[s.length()];
    }
