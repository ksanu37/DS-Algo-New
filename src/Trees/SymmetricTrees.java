package Trees;

/*
https://leetcode.com/problems/symmetric-tree/
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:

Input: root = [1,2,2,3,4,4,3]
Output: true

The idea is to recursively check whether the left and right subtrees are mirrors of each other or not
 */

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


public class SymmetricTrees {
    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return true;

        if((root.left == null && root.right != null) || (root.right==null && root.left!=null))
            return false;

        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right){
        if(left==null && right==null)
            return true;
        if((left == null && right != null) || (right == null && left !=null))
            return false;
        if(left.val != right.val)
            return false;

        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
