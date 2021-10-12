package Trees;

/*
    https://leetcode.com/problems/validate-binary-search-tree/

    Given the root of a binary tree, determine if it is a valid binary search tree (BST).

    A valid BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

    The idea is to maintain a maxNode and a minNode for the subtrees.
    If any node in the left subtree exceeds the maxNode, it is not a BST.
    Similarly, if any node in the right subtree is smaller than the minNode, it is not a BST.

    The maxNode for leftSubtree will be the root itSelf, minNode will be null as left can be as small as possible.
    The minNode for rightSubtree will be the root, no limit on maxNode.
 */

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, TreeNode minNode, TreeNode maxNode){
        if(root == null)
            return true;

        if((minNode!= null && root.val <= minNode.val) ||
                (maxNode!= null && root.val >= maxNode.val))
            return false;

        return isValidBST(root.left, minNode, root) && isValidBST(root.right, root, maxNode);
    }
}
