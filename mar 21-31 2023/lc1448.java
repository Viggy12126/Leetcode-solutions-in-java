// Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

// Return the number of good nodes in the binary tree.

class Solution {
    int ans=0;

    public void helper(TreeNode root,int max,String psf){

        if(root==null)
        return;

        if(root.val>=max){
        ans++;
        max=root.val;
//         psf=psf+root.val;
// System.out.println(psf);
        }

        helper(root.left,max,psf+root.val);
        helper(root.right,max,psf+root.val);
    }

    public int goodNodes(TreeNode root) {
        
        helper(root,-100001,"");

        return ans;
    }
}
