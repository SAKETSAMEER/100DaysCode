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

    static HashMap<Integer,Integer> hp;

    static void helper(TreeNode root){
        if(root==null) return;

        hp.put(root.val,hp.getOrDefault(root.val,0)+1);
        helper(root.left);
        helper(root.right);
    }
    public int[] findMode(TreeNode root) {
        hp = new HashMap<>();
        helper(root);

        int max = Integer.MIN_VALUE;
        for(var a : hp.values()) max = Math.max(max,a);
        int n = 0;
        for(var a : hp.values()){
            if(a==max) n++;
        }

        int ans[] = new int[n];
        int i=0;
        for(var a : hp.keySet()){
            if(hp.get(a)==max) ans[i++] = a;
        }
        return ans;
    }
}