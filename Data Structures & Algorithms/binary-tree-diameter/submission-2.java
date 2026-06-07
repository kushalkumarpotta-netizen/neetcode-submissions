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
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        heightOfBT(root);
        return diameter;
    }

    public int heightOfBT(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }

        int left = heightOfBT(root.left);
        int right = heightOfBT(root.right);

        diameter = Math.max(diameter,heightOfBT(root.left) + heightOfBT(root.right));

        return Math.max(left, right) + 1;
    }
}
