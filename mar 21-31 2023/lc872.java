// Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.

// For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

// Two binary trees are considered leaf-similar if their leaf value sequence is the same.

// Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
class Solution {

        

     public void helper2(TreeNode root,  ArrayList<Integer> arr2){

        if(root==null)
        return;
        
        if(root.left==null && root.right==null){
            arr2.add(root.val);
            return;
            // System.out.println("helper2"+" "+s2[0]);
        }

        helper2(root.left,arr2);
         helper2(root.right,arr2);

    }

    public void helper1(TreeNode root,  ArrayList<Integer> arr1){

        if(root==null)
        return;
        
        if(root.left==null && root.right==null){
            arr1.add(root.val);
            return;
            //  System.out.println("helper1"+" "+s1[0]);
        }

        helper1(root.left,arr1);
         helper1(root.right,arr1);

    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
    // String[] s1=new String[1];
    //    String[] s2=new String[1];
    //    s1[0]="";
    //    s2[0]="";

    ArrayList<Integer> arr1=new ArrayList<>();
     ArrayList<Integer> arr2=new ArrayList<>();

        helper1(root1,arr1);
        helper2(root2,arr2);

        //    System.out.println(s1[0]+" "+s2[0]);

        // if(s1[0].equals(s2[0]))
        // return true;

        // return false;

        if(arr1.size()==arr2.size()){
         
         for(int i=0;i<arr1.size();i++){
             if(arr1.get(i)!=arr2.get(i))
             return false;
         }

         return true;
        }else
        return false;

    }
}