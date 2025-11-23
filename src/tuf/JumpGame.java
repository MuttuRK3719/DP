Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index

108ms
public boolean canJump(int[] nums) {
        if (nums.length <= 1)
            return true;
        if (nums.length == 2)
            return nums[0] > 0;

        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j <= i + nums[i]; j++) {
                if (dp[j] || j >= nums.length) {
                    dp[i] = true;
                    break;
                }
            }

        }
        return dp[0];
    }

1ms
    public boolean canJump(int[] nums) {
        int lastIndex=nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]+i>=lastIndex){
                lastIndex=i;
            }
        }
        return lastIndex==0;
    }
