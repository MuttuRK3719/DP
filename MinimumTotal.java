Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, 
if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10

public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        int[] dp = new int[m+1];
        for (int i = m- 1; i >= 0; i--) {
            int n=triangle.get(i).size();
            for (int j = 0; j < n; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size() - 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return findMinPath(triangle, 0, 0, dp);
    }

int findMinPath(List<List<Integer>> triangle, int i, int j, int[][] dp) {
        if (i == triangle.size() - 1)
            return triangle.get(i).get(j);
        if (dp[i][j] != Integer.MIN_VALUE)
            return dp[i][j];
        int left = findMinPath(triangle, i + 1, j, dp);
        int right = findMinPath(triangle, i + 1, j + 1, dp);
        return dp[i][j] = triangle.get(i).get(j) + Math.min(left, right);
    }
