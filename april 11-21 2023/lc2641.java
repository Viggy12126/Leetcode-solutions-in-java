
// Given the root of a binary tree, replace the value of each node in the tree with the sum of all its cousins' values.

// Two nodes of a binary tree are cousins if they have the same depth with different parents.

// Return the root of the modified tree.

// Note that the depth of a node is the number of edges in the path from the root node to it.

class Solution {
    
    class Pair{
            TreeNode node;
            int sib_sum;
            // int tot_sum;
            
        public  Pair( TreeNode node, int sib_sum){
            
            this.node=node;
            this.sib_sum=sib_sum;
            // this.tot-sum=tot_sum;
        }
            
        }
        public TreeNode replaceValueInTree(TreeNode root) {
            
            Queue<Pair> queue=new LinkedList<>();
            Queue<TreeNode> q=new LinkedList<>();
            HashMap<Integer,Integer> map=new HashMap<>();
            int level=0;
           q.add(root);
            
            while(q.size()>0){
                int sum=0;
               int size=q.size();
                
                for(int i=0;i<size;i++){
                   TreeNode rem=q.poll();
                    sum+=rem.val;
                    
                    if(rem.left!=null)
                        q.add(rem.left);
                        
                        if(rem.right!=null)
                            q.add(rem.right);
                }
                
                map.put(level,sum);
                level++;
            }
            
            level=0;
            queue.add(new Pair(root,root.val));
            
            while(queue.size()>0){
                  int size=queue.size();
                
                for(int i=0;i<size;i++){
                    
                    Pair rem=queue.poll();
                    
                    Pair temp=rem;
                    
                    int total=map.get(level);
                    int sibsum=rem.sib_sum;
                    
                    rem.node.val=total-sibsum;
                    int sum=0;
                    
                    if(temp.node.left!=null){
                        sum+=temp.node.left.val;
                    }
                    
                    if(temp.node.right!=null){
                        sum+=temp.node.right.val;
                    }
                    
                    
                     if(temp.node.left!=null){
                        queue.add(new Pair(temp.node.left,sum));
                    }
                    
                     if(temp.node.right!=null){
                        queue.add(new Pair(temp.node.right,sum));
                    }
                    
                    
                    
                }
                level++;
            }
            
            
            return root;
            
            
        }
    }
