 public int numDecodings(String s) {
        int prev1 = 1, prev2 = 1;
        if (s.charAt(0) == '0')
            return 0;
        for (int i = 1; i < s.length(); i++) {
            int current = 0;
            if (s.charAt(i) != '0')
                current = prev1;

            int val = 10 * (s.charAt(i - 1) - '0') + s.charAt(i) - '0';
            if (val >= 10 && val <= 26)
                current += prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
