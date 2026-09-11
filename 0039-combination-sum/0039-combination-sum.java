class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }
    private void findCombinations(int[] candidates, int target, int start,
     List<Integer> current, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            findCombinations(candidates, target - candidates[i], i,current, ans);
            current.remove(current.size() - 1);
        }
    }
}
