// Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.

class Solution {

    Set<Integer> set=new HashSet<>();

    public boolean helper(TreeNode root, int k){

        if(root==null)
        return false;

        if(set.contains(k-root.val))
        return true;

        set.add(root.val);

       return helper(root.left,k) || helper(root.right,k);
        
    }
    public boolean findTarget(TreeNode root, int k) {

        return helper(root,k);
        
    }
}
