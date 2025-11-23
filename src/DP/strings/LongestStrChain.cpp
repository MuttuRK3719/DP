bool checkString(string s1, string s2) {
        if (s1.size() != s2.size() + 1)
            return false;
        int first = 0, second = 0;
        while (first < s1.size()) {
            if (second < s2.size() && s1[first] == s2[second]) {
                first++;
                second++;
            } else {
                first++;
            }
        }
        return second == s2.size() && first == s1.size();
    }
    static bool comp(string& s1, string& s2) { 
return s1.size() < s2.size();
}
    int longestStrChain(vector<string>& words) {
        int maxi = 0, n = words.size();
        vector<int> dp(n, 1);
        sort(words.begin(), words.end(), comp);
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (dp[prev] + 1 > dp[i] &&
                    checkString(words[i], words[prev])) {
                    dp[i] = dp[prev] + 1;
                }
            }
            if (dp[i] > maxi) {
                maxi = dp[i];
            }
        }
        return maxi;
    }
