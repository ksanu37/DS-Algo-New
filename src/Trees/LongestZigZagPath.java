package Trees;

/*
https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
 */
public class LongestZigZagPath {

    public int longestZigZag(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int res = 0;
        res = Math.max(res, getMaxOfThreeValues(numberOfNodesInZigZagPath()))
    }

    public int getMaxOfThreeValues(int a, int b, int c) {
        return (a>b) ? (a>c) ? a: c : (b>c)?b:c;
    }
    public int numberOfNodesInZigZagPath(TreeNode root){
        int maxNodes = 0;
        TreeNode temp = root;
        boolean leftNode = true;
        int node = 0;
        if (temp!=null)
            node++;
        while(temp != null){
            if(leftNode && temp.left != null) {
                node++;
                temp = temp.left;
                leftNode = false;
            } else if(!leftNode && temp.right != null){
                leftNode = true;
                node++;
                temp = temp.right;
            }
        }

        maxNodes = Math.max(maxNodes, node);

        temp = root;
        boolean rightNode = true;
        node = 0;
        if (temp!=null)
            node++;
        while(temp != null){
            if(rightNode && temp.right != null) {
                node++;
                temp = temp.right;
                rightNode = false;
            } else if(!rightNode && temp.left != null){
                rightNode = true;
                node++;
                temp = temp.left;
            }
        }

        maxNodes = Math.max(maxNodes, node);
        return maxNodes;
    }
}
