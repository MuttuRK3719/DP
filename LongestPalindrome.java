public String longestPalindrome(String s) {
        int right = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = getSizeOfPolindrome(s, i, i);
            int len2 = getSizeOfPolindrome(s, i, i + 1);
            len2 = Math.max(len1, len2);
            if (len2 > right - left) {
                left = i - (len2 - 1) / 2;
                right = i + (len2) / 2;
            }
        }
        return s.substring(left, right + 1);
    }

    int getSizeOfPolindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
