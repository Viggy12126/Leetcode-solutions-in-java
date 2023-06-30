// You are given a directed graph of n nodes numbered from 0 to n - 1, where each node has at most one 
// outgoing edge.

// The graph is represented with a given 0-indexed array edges of size n, indicating that there is a directed 
// edge from node i to node edges[i]. If there is no outgoing edge from node i, then edges[i] == -1.

// Return the length of the longest cycle in the graph. If no cycle exists, return -1.

// A cycle is a path that starts and ends at the same node.

public class longest_cycle_in_graph {
    int ans=-1;

    public boolean dfs(int[] edges,boolean[] vis,int[] count,int i,int start){

        vis[i]=true;
        int neighbour=edges[i];
        
        count[0]++;

        if(neighbour!=-1 && !vis[neighbour]){
            
boolean found=dfs(edges,vis,count,neighbour,start);

if(found)
  return true;

        }else if(neighbour!=-1 && neighbour==start){
            
return true;
     }

vis[i]=false;
        return false;
    }
    public int longestCycle(int[] edges) {
        
        int n=edges.length;
        boolean[] vis=new boolean[n];

        for(int i=0;i<n;i++){
            int[] count=new int[1];
            if(!vis[i]){
              
                 if(dfs(edges,vis,count,i,i)){
                ans=Math.max(ans,count[0]);
                 }
                
          
            }
           
        }

        return ans;
        
    }
}
