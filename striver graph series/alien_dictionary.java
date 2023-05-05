// Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. Find the order of characters in the alien language.
// Note: Many orders may be possible for a particular test case, thus you may return any valid order and output will be 1 if the order of string returned by the function is correct else 0 denoting incorrect string returned.


import java.util.*;
public class alien_dictionary {
    

//User function Template for Java
public String findOrder(String [] dict, int N, int K)
   {
       // Write your code here
       ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
       for(int i=0;i<K;i++)
           adj.add(new ArrayList<>());
       for(int i=0;i<N-1;i++)
       {
           String s1=dict[i];
           String s2=dict[i+1];
           for(int j=0;j<Math.min(s1.length(),s2.length());j++)
           {
               if(s1.charAt(j)!=s2.charAt(j))
               {
                   adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
               }
           }
       }
       int indegree[]=new int[K];
       char res[]=new char[K];
       for(int i=0;i<adj.size();i++)
       {
           for(int x:adj.get(i))
           {
               indegree[x]++;
           }
       }
       Queue<Integer> q=new LinkedList<>();
       for(int i=0;i<K;i++)
       {
           if(indegree[i]==0)
               q.add(i);
       }
       int count=0;
       while(!q.isEmpty())
       {
           int u=q.poll();
           res[count++]=(char)(u+'a');
           for(int x:adj.get(u))
           {
               if(--indegree[x]==0)
                   q.add(x);
           }
       }
       String ans="";
       for(int i=0;i<K;i++)
       {
           ans+=res[i];
       }
       return ans;
   }

}
