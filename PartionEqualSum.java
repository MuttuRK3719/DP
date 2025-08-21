Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.

  

public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int ele : nums)
            sum += ele;
        if (sum % 2 == 1)
            return false;
        sum/=2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j =sum; j >=nums[i]; j--) {
                if (dp[j - nums[i]]) {
                    dp[j] = true;
                }

            }
        }
        return dp[sum];
    }


int sum =0;
        for(int num : nums)
            sum += num;
        if(sum % 2 == 1)
            return false;
        sum /= 2;
        BitSet ans = new BitSet(sum + 1);
        ans.set(sum);
        for(int num : nums){
            if(num > sum)
                continue;
            ans.or(ans.get(num , sum+1));
            if(ans.get(0))
                return true;  
        }
        return false;
    }
