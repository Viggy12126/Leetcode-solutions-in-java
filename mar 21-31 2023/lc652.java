// Given the root of a binary tree, return all duplicate subtrees.

// For each kind of duplicate subtrees, you only need to return the root node of any one of them.

// Two trees are duplicate if they have the same structure with the same node values.

class Solution {
    Map<String,Integer> map=new HashMap<>();
List<TreeNode> ans=new ArrayList<>();

public String helper(TreeNode root){

   if(root==null)
   return "";

   String left=helper(root.left);
   String right=helper(root.right);

   String curr=root.val+" "+left+" "+right;
    map.put(curr, map.getOrDefault(curr, 0)+ 1);

    if(map.get(curr)==2)
    ans.add(root);

    return curr;
   
}

   public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
       
       helper(root);
       return ans;
   }
}
