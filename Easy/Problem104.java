/*

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
class Problem104 {
    /*  Recursive
    	public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        else {
            return (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
        }
    }*/
    
    // Iterative
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        int depth = 0;
        
        while(!q.isEmpty()) {
            TreeNode temp = q.remove();
            if(temp == null) {
                depth++;
                if(!q.isEmpty()) {
                    q.add(null);
                }
            }
            else {
                if(temp.right != null) {
                    q.add(temp.right);
                }
                if(temp.left != null) {
                    q.add(temp.left);
                }
            }
        }
        
        return depth;
    }
}