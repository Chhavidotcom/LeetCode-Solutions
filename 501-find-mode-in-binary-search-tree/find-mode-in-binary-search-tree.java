/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     HashMap<Integer,Integer>map =new HashMap<>();
    public int[] findMode(TreeNode root) {
       
        

        inOrder(root);

       int max = 0;

        for (int count : map.values()) {
            max = Math.max(max, count);
        }

        List<Integer> ans = new ArrayList<>();

        for (int value : map.keySet()) {
            if (map.get(value) == max) {
                ans.add(value);
            }
        }

        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
        }

    

    public void inOrder(TreeNode t){

        if(t==null){
            return;
        }
        inOrder(t.left);
       map.put(t.val, map.getOrDefault(t.val, 0) + 1);
        inOrder(t.right);
    }
}