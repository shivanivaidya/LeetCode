/*

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].

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
 
 
class Problem199 {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> output = new ArrayList<Integer>();
        
        q.add(root);
        q.add(null);
        
        if(root == null) return output;
        
        while(!q.isEmpty()) {
            TreeNode temp = q.remove();
            
            if(temp != null) {
                if(q.peek() == null) {
                    output.add(temp.val);
                }
                if(temp.left != null) {
                    q.add(temp.left);
                }
                if(temp.right != null) {
                    q.add(temp.right);
                }
            }
            else {
                if(!q.isEmpty()) {
                    q.add(null);
                }
            }
        }
        return output;
    }
}