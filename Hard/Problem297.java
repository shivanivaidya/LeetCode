/*

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example: 

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

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
public class Problem297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return new String();
        
        ArrayList<String> result = new ArrayList<String>();
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int flag = 1;
        
        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            if(temp != null) {
                flag--;
                result.add(String.valueOf(temp.val));
                
                if(temp.left != null)
                    flag++;
                if(temp.right != null)
                    flag++;
                    
                q.offer(temp.left);
                q.offer(temp.right);
            }
            else if(flag > 0) {
                result.add(null);
            }
        }
        return result.toString().replaceAll(" ", "");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))
            return null;
        
        String[] tree = data.replaceAll("[\\[\\]]","").split(",");
        
        TreeNode root = null;
        TreeNode parent = null;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        int i = 0;
        while(i < tree.length) {
            if(root == null) {
                TreeNode temp = new TreeNode(Integer.parseInt(tree[i]));
                root = temp;
                parent = root;
                i++;
                continue;
            }
              
            if(i >= tree.length)
                break;
            else if(tree[i].equals("null")) {
                parent.left = null;
            }
            else {
                TreeNode temp = new TreeNode(Integer.parseInt(tree[i]));
                parent.left = temp;
                q.add(temp);
            }
            i++;
            
            if(i >= tree.length)
                break;
            else if(tree[i].equals("null")) {
                parent.right = null;
            }
            else {
                TreeNode temp = new TreeNode(Integer.parseInt(tree[i]));
                parent.right = temp;
                q.add(temp);
            }
            i++;
            
            parent = q.poll();
            
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));