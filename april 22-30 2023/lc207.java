// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.

import java.util.*;
class Solution {
    public boolean canFinish(int n, int[][] arr) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

         for(int i=0;i<arr.length;i++){
           adj.get(arr[i][1]).add(arr[i][0]);
        }

          int[] indegree=new int[n];
        ArrayList<Integer> ans=new ArrayList<>();
        
        Queue<Integer> queue=new LinkedList<>();
        
        for(int i=0;i<n;i++){
            
            for(int ind:adj.get(i)){
                indegree[ind]++;
                // System.out.println("first"+" "+indegree[ind]);
            }
        }
        
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
            queue.add(i);
//  System.out.println("sec"+" "+indegree[i]);
            }
        }
        
        int i=0;
        while(queue.size()>0){
            int node=queue.poll();
            // System.out.println("node is "+" "+node);
           ans.add(node);
            
            for(int ind:adj.get(node)){
                indegree[ind]--;
                
                if(indegree[ind]==0)
                queue.add(ind);
            }
        }


        if(ans.size()==n)
        return true;

        return false;
    }
}