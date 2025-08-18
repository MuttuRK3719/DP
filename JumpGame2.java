
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

Input: nums = [2,3,0,1,4]
Output: 2

        
public static  int jump(int[] nums) {
        int currentIndex = 0, currentMax = -1, jump = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            currentMax = Math.max(currentMax, i + nums[i]);
            if (currentIndex == i) {
                jump++;
                currentIndex = currentMax;
            }
        }
        return jump;
    }
