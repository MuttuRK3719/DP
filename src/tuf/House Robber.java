 public int rob(int[] nums) {

        int prev2 = 0;
        int prev = 0;

        for (int i = 0; i < nums.length; i++) {
            int current = Math.max(prev2, nums[i] + prev);
            prev = prev2;
            prev2 = current;
        }
        return prev2;
    }
