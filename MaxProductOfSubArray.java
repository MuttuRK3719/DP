Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
  

public int maxProduct(int[] nums) {
        int max = 1, min = 1, pro = 1;
        if (nums.length == 1)
            return nums[0];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = max * nums[i];
            max = Math.max(nums[i], Math.max(nums[i] * min, nums[i] * max));
            min = Math.min(nums[i], Math.min(nums[i] * min, temp));
            result = Math.max(result, Math.max(min, max));
        }
        return result;
    }


public int maxProduct(int[] nums) {
        int pro = 1;
        int max = Integer.MIN_VALUE;
        for (int ele : nums) {
            pro *= ele;
            if (pro > max)
                max = pro;
            if (pro == 0)
                pro = 1;
        }
        pro = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            pro *= nums[i];
            if (pro > max)
                max = pro;
            if (pro == 0)
                pro = 1;
        }
        return max;
    }
