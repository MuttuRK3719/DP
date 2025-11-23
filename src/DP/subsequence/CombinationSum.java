Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []

public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combinations = new ArrayList<>();
        backTracking(candidates, target, 0, combinations, result);
        return result;
    }

    void backTracking(int[] candidates, int target, int start, List<Integer> combinations, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(combinations));
        }
        if (target < 0)
            return;
        for (int i = start; i < candidates.length; i++) {
            combinations.add(candidates[i]);
            backTracking(candidates, target - candidates[i], i, combinations, result);
            combinations.remove(combinations.size() - 1);
        }
    }
