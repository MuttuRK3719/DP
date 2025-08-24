https://leetcode.com/problems/word-break/
Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

     
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
