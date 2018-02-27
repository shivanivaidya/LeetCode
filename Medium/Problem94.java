/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

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
class Problem94 {
    /*public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorderTraversalHelper(root, list); 
        return list;
    }
    
    public void inorderTraversalHelper(TreeNode root, List<Integer> list) {
        if(root != null) {
            inorderTraversalHelper(root.left, list);
            list.add(root.val);
            inorderTraversalHelper(root.right, list);
        }
    }*/
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        
        TreeNode curr = root;
        while (curr != null || !s.isEmpty()) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }
}