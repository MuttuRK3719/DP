
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
