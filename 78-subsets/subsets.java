class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr= new ArrayList<>();
        helper(nums,curr,0,ans);
        return ans;
    }
    public void helper(int[] nums,List<Integer> curr, int i, List<List<Integer>> ans){
     if(i>=nums.length){
        ans.add(new ArrayList<>(curr));
        return;
     }
         
        curr.add(nums[i]);
        helper(nums,curr,i+1,ans);
        curr.remove(curr.size()-1);
        helper(nums,curr,i+1,ans);
    }
}