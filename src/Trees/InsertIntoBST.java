package Trees;

/*
    https://leetcode.com/problems/insert-into-a-binary-search-tree/
    You are given the root node of a binary search tree (BST) and a value to insert into the tree.
    Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
    Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion.
    You can return any of them.
    Input: root = [4,2,7,1,3], val = 5
    Output: [4,2,7,1,3,5]

    The idea is to recursively check if inserting a node will satisfy the conditions for a tree to be a BST.
 */


public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);

        if(root.left == null && root.right == null){
            if(root.val<val)
                root.right = new TreeNode(val);
            else
                root.left = new TreeNode(val);

            return root;
        }

        if(root.right == null){
            if(root.val<val)
                root.right = new TreeNode(val);
            else
                root.left = insertIntoBST(root.left, val);
        }
        else if(root.left == null){
            if(root.val> val)
                root.left = new TreeNode(val);
            else
                root.right = insertIntoBST(root.right, val);
        }

        else {
            if(root.val < val)
                root.right = insertIntoBST(root.right, val);
            else
                root.left = insertIntoBST(root.left, val);
        }

        return root;
    }
}
