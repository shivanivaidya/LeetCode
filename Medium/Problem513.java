/*
Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2: 
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
Note: You may assume the tree (i.e., the given root node) is not NULL.

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
 
 
class Problem513 {
    public int findBottomLeftValue(TreeNode root) {
        int leftMost = root.val;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            TreeNode temp = q.remove();
            if(temp == null) {
                if(q.isEmpty()) {
                    return leftMost;
                }
                else {
                    q.add(null);
                }
            }
            else {
                leftMost = temp.val;
                if(temp.right != null) {
                    q.add(temp.right);
                }
                if(temp.left != null) {
                    q.add(temp.left);
                }
            }
        }
        
        return leftMost;
    }
}