// You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm:

// Create a root node whose value is the maximum value in nums.
// Recursively build the left subtree on the subarray prefix to the left of the maximum value.
// Recursively build the right subtree on the subarray suffix to the right of the maximum value.
// Return the maximum binary tree built from nums.


class Solution {

    public TreeNode helper(int[] nums,int low,int high){

        if(low>high)
        return null;

        int max_index=low;

        for(int i=low+1;i<=high;i++){
            if(nums[i]>nums[max_index]){
                max_index=i;
            }
        }

        TreeNode root=new TreeNode(nums[max_index]);

        root.left=helper(nums,low,max_index-1);
        root.right=helper(nums,max_index+1,high);

        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return helper(nums,0,nums.length-1);
        
    }
}
