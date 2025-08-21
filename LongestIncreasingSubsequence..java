Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4

Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4
  
Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1

public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            if (dp[i] > max)
                max = dp[i];
        }
        return max;
    }


 public int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > sub.get(sub.size() - 1)) {
                sub.add(nums[i]);
            } else {
                int j = binarySearch(sub, nums[i]);
                sub.set(j, nums[i]);
            }
        }
        return sub.size();
    }

    int binarySearch(List<Integer> list, int val) {
        int start = 0,end = list.size() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) == val)
                return mid;
            else if (list.get(mid) > val) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
