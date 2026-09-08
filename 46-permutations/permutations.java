class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, new ArrayList<>());

        return ans;
    }

    void backtrack(int[] nums, boolean[] used, List<Integer> path) {

        // permutation complete
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // har number try karo
        for (int i = 0; i < nums.length; i++) {

            // already use ho chuka hai
            if (used[i]) {
                continue;
            }

            // choose
            path.add(nums[i]);
            used[i] = true;

            // recursion
            backtrack(nums, used, path);

            // undo
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}