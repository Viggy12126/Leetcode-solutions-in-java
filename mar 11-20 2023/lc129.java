// You are given the root of a binary tree containing digits from 0 to 9 only.

// Each root-to-leaf path in the tree represents a number.

// For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
// Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

// A leaf node is a node with no children.

 public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
       }
     }

class Solution {
    // int ans=0;

    public void helper(TreeNode root,int sum,int[] ans){

        if(root==null)
        return;

        if(root.left==null && root.right==null){
            ans[0]+=sum;
            return;
        }

if(root.left!=null)
        helper(root.left,sum*10+root.left.val,ans);

        if(root.right!=null)
        helper(root.right,sum*10+root.right.val,ans);
    }
    public int sumNumbers(TreeNode root) {
        
        int[] ans=new int[1];
         helper(root,root.val,ans);

         return ans[0];
    }
}
