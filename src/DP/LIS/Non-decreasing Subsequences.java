Example 1:

Input: nums = [4,6,7,7]
Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
Example 2:

Input: nums = [4,4,3,2,1]
Output: [[4,4]]

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtracking(nums, 0, current, res);
        return res;
    }

    void backtracking(int[] nums, int index, List<Integer> current, List<List<Integer>> res) {
        if (current.size() >= 2) {
            res.add(new ArrayList<>(current));
        }
        Set<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (used.contains(nums[i]))
                continue;
            if (current.size() > 0 && nums[i] < current.getLast())
                continue;
            used.add(nums[i]);
            current.add(nums[i]);
            backtracking(nums, i + 1, current, res);
            current.removeLast();
        }
    }
}
