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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode root, int maxTillNow)
    {
        if(root == null)
        {
            return 0;
        }

        int count = 0;

        if(root.val>=maxTillNow)
        {
            count = 1;
        }

        maxTillNow = Math.max(root.val,maxTillNow);

        count += dfs(root.left,maxTillNow);
        count += dfs(root.right,maxTillNow);
        
        return count;
    }
}
