class Solution {
    public int subsetXORSum(int[] nums) {
        
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    helper(nums,0,curr,ans);
        int sum = 0;

        for (List<Integer> list : ans) {
            int xor = 0;

            for (int num : list) {
                xor = xor ^ num;
            }

            sum += xor;
        }

        return sum;
    }
 
    public void helper(int[] nums, int i, List<Integer> curr,List<List<Integer>> ans ) {

        if (i >= nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        helper(nums,i+1,curr,ans);
        curr.remove(curr.size()-1);
        helper(nums,i+1,curr,ans);
    }
}