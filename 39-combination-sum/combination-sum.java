class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        solve(0, target, candidates, new ArrayList<>(), ans);

        return ans;
    }

    public void solve(int i, int target, int[] candidates,
                      List<Integer> temp, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (i == candidates.length || target < 0) {
            return;
        }

        temp.add(candidates[i]);

        solve(i, target - candidates[i], candidates, temp, ans);

        temp.remove(temp.size() - 1);

        solve(i + 1, target, candidates, temp, ans);
    }
}