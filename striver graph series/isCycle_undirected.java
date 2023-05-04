
import java.util.*;
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
       
        boolean[] visited=new boolean[V];
          for(int i=0;i<V;i++)
       {
           visited[i] = false;
       }
        
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
            boolean ans= isCycleHelper(adj,visited,-1,i);
            if(ans)
            return true;
            }
        }
        
        return false;
        
        
    }
    public static boolean isCycleHelper(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int prev, int src ){
        
        
        visited[src]=true;
        
        for(Integer i:adj.get(src)){
            if(!visited[i]){
                if(isCycleHelper(adj,visited,src,i))
                return true;
            }else {
                if(i!=prev)
                return true;
            }
        }
        
        return false;
    }
}