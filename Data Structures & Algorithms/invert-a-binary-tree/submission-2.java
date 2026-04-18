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
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }
    private void dfs(TreeNode node){
        if(node==null)
            return;
        if(node.left!=null || node.right!=null){
            TreeNode temp = node.right;
            node.right = node.left;
            node.left = temp;
        }
        else
            return;
        dfs(node.left);
        dfs(node.right);
    }
}
