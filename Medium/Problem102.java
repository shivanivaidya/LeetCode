/*

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

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
 
class Problem102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        if(root == null) {
            return output;
        }
        
        q.add(root);
        int currSize = 0;
        
        while(!q.isEmpty()) {
            currSize = q.size();
            List<Integer> tempList = new ArrayList<Integer>();
            
            for(int i = 0; i<currSize; i++) {
                TreeNode temp = q.remove();
                tempList.add(temp.val);
                
                if(temp.left != null) {
                    q.add(temp.left);
                }
                
                if(temp.right != null) {
                    q.add(temp.right);
                }
            }
            
            output.add(tempList);
        }
        
        return output;
    }
}