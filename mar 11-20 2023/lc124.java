// A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

// The path sum of a path is the sum of the node's values in the path.

// Given the root of a binary tree, return the maximum path sum of any non-empty path.

class Solution {
    int sum=Integer.MIN_VALUE;

   public int dfs(TreeNode root){

       if(root==null)
       return 0;

       int left=Math.max(dfs(root.left),0);
       int right=Math.max(dfs(root.right),0);


sum=Math.max(sum,root.val+left+right);
       return root.val+Math.max(left,right);
   }
   public int maxPathSum(TreeNode root) {

       dfs(root);
       return sum;
       
   }
}
