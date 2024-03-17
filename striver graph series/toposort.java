import java.util.*;

class Solution
{
    //Function to return list containing vertices in Topological order. 
    
    public static void helper(ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, boolean[] visited,int i){
        
        visited[i]=true;
        
        for(Integer n:adj.get(i)){
            if(!visited[n])
            helper(adj,st,visited,n);
        }
        
        st.push(i);
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[V];
        
        boolean[] visited=new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!visited[i])
            helper(adj,st,visited,i);
        }
        
        int temp=0;
        while(st.size()>0){
            ans[temp]=st.pop();
            temp++;
        }
        
        return ans;
    }

}