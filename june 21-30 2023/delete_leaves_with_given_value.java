// Given a binary tree root and an integer target, delete all the leaf nodes with value target.

// Note that once you delete a leaf node with value target, 
// if its parent node becomes a leaf node and has the value target, it should also be deleted 
// (you need to continue doing that until you cannot).

public class delete_leaves_with_given_value {

       public class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
  }

     public TreeNode removeLeafNodes(TreeNode root, int target) {
        
         if(root==null)
            return null;
        
        if(root.left==null && root.right==null && root.val==target)
            return null;

            TreeNode left=removeLeafNodes(root.left,target);
            
            TreeNode right=removeLeafNodes(root.right,target);

          if(left==null && right==null && root.val==target)
            return null;
            else{
                root.left=left;
                root.right=right;
            }

            return root;

    }
}
