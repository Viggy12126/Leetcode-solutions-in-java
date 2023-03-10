// You are given the root of a binary tree and a positive integer k.

// The level sum in the tree is the sum of the values of the nodes that are on the same level.

// Return the kth largest level sum in the tree (not necessarily distinct). If there are fewer than k levels in the tree, return -1.

// Note that two nodes are on the same level if they have the same distance from the root.


import java.util.*;

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
    public long kthLargestLevelSum(TreeNode root, int k) {
        
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        queue.add(null);
        long sum=0;
        
        ArrayList<Long> arr=new ArrayList<>();
        
        while(queue.size()>0){
           TreeNode remNode=queue.poll();
            
            
            if(remNode==null){
                
                 arr.add(sum);
                sum=0;
                
                if(queue.size()==0)
                    break;
                
                queue.add(null);
               
                
                // System.out.println(-1);
                
            }else{
                
                  // System.out.println(remNode.val);
                sum+=remNode.val;
                
                if(remNode.left!=null)
                    queue.add(remNode.left);
                
                if(remNode.right!=null)
                    queue.add(remNode.right);
            }
        }
        
        Collections.sort(arr);
        System.out.println(arr);
        
        if(k>arr.size())
            return -1;
        
        return arr.get(arr.size()-k);
        
    }
}