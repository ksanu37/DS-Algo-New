package Trees;
/*
   https://leetcode.com/problems/invert-binary-tree/

   Given the root of a binary tree, invert the tree, and return its root.
   Example 1:
    Input: root = [4,2,7,1,3,6,9]
    Output: [4,7,2,9,6,3,1]

    The idea is to recursively solve for each node, starting to reverse the links with the leaf nodes.
 */

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;

        if(root.left == null && root.right == null)
            return root;

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}
