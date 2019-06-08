/*

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
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
class Problem103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        int levelNo = 0;
        int levelSize = 0;
        
        while(!q.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            levelSize = q.size();
            
            for(int i = 0; i<levelSize; i++) {
                TreeNode temp = q.poll();
                
                if(levelNo % 2 == 0) 
                    level.add(temp.val);
                else
                    level.add(0, temp.val);
                
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            
            result.add(level);
            levelNo++;
        }
        return result;
    }
}