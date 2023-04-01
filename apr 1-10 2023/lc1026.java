
// Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.

// A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.

class Solution {
int max_diff=0;

public void helper(TreeNode root,int max,int min){

    if(root==null)
    return;

      max=Math.max(max,root.val);
      min=Math.min(min,root.val);

max_diff=Math.max(max_diff,Math.abs(max-min));

helper(root.left,max,min);
helper(root.right,max,min);

}
//    public int helper(TreeNode root,int max,int min,int max_diff){

//        if(root==null)
//        return max_diff;

//        max=Math.max(max,root.val);
//        min=Math.min(min,root.val);
 
//       max_diff=Math.max(max_diff,Math.abs(max-min));

//       int ls=helper(root.left,max,min,max_diff);
//       int rs=helper(root.right,max,min,max_diff);

//       return Math.max(ls,rs);

//    }

    public int maxAncestorDiff(TreeNode root) {

     helper(root,-1,5001);

     return max_diff;
        
    }
}