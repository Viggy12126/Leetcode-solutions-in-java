// There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

// You want to determine if there is a valid path that exists from vertex source to vertex destination.

// Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.

 


import java.util.*;
class Solution {

    public boolean dfs(ArrayList<Integer>[]  adj,int source, int destination,boolean[] vis){
        

        if(source==destination)
        return true;

        vis[source]=true;

        for(int nbr:adj[source]){

            if(!vis[nbr]){
            boolean ans=dfs(adj,nbr,destination,vis);

            if(ans)
            return true;
            }
        }

        return false;
         
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        ArrayList<Integer>[] adj=new ArrayList[n];
        boolean[] vis=new boolean[n];

        for(int i=0;i<n;i++){
            // 
              adj[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<edges.length;i++){
            // System.out.println(edges[i][0]+" "+edges[i][1]);
            // int first=edges[i][0];
            // int sec=edges[i][1];

            // adj.get(first).add(sec);
            // adj.get(sec).add(first);

              adj[edges[i][0]].add(edges[i][1]);
         adj[edges[i][1]].add(edges[i][0]);
        }

        return dfs(adj,source,destination,vis);
    }
}
