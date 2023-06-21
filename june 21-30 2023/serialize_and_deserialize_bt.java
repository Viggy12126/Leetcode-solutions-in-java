  import java.util.*;

public class serialize_and_deserialize_bt {

      public class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
  }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        StringBuilder sb=new StringBuilder();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode rem=queue.remove();
           if(rem==null){
                sb.append("n ");
                // continue;
            }else{
                sb.append(rem.val+" ");
                queue.add(rem.left);
                queue.add(rem.right);
            
            }
            

          

        }
    //    System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data.length()==0)
        return null;

        String[] nodes=data.split(" ");
        Queue<TreeNode> queue=new LinkedList<>();
        //  System.out.println(nodes.length);
        // for(int i=0;i<nodes.length;i++)
        // System.out.println(nodes[i]);

        TreeNode root=null;

if(!nodes[0].equals("n"))
        root=new TreeNode(Integer.parseInt(nodes[0]));
      queue.add(root);

      for(int i=1;i<nodes.length;i++){
          TreeNode rem=queue.poll();

          if(!nodes[i].equals("n")){
              TreeNode left=new TreeNode(Integer.parseInt(nodes[i]));
              rem.left=left;
              queue.add(left);
          }

           if(!nodes[++i].equals("n")){
              TreeNode right=new TreeNode(Integer.parseInt(nodes[i]));
              rem.right=right;
              queue.add(right);
          }

      }

      return root;
    }
}