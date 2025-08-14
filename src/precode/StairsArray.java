package precode;

public class StairsArray {
    public static void main(String[] args) {
    int[]arr={3,3,0,2,2,3};
        System.out.println(getPossible(arr));
    }

    static int getPossible(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[nums.length]=1;
        for (int i = nums.length-1;i>=0;i--) {
        int k = 0;
            for (int j = nums[i]; j > 0; j--) {
                if (i+j > nums.length) continue;
                k+=dp[i+j];
            }
            dp[i]=k;
        }
        return dp[0];
    }

}
