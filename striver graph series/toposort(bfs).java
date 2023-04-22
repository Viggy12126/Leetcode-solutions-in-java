import java.util.*;

class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        
        int[] indegree=new int[V];
        int[] ans=new int[V];
        
        Queue<Integer> queue=new LinkedList<>();
        
        for(int i=0;i<V;i++){
            
            for(int ind:adj.get(i)){
                indegree[ind]++;
            }
        }
        
        for(int i=0;i<V;i++){
            if(indegree[i]==0)
            queue.add(i);
        }
        
        int i=0;
        while(queue.size()>0){
            int node=queue.poll();
            
            ans[i++]=node;
            
            for(int ind:adj.get(node)){
                indegree[ind]--;
                
                if(indegree[ind]==0)
                queue.add(ind);
            }
        }
        
        return ans;
    }
}
