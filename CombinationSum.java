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
