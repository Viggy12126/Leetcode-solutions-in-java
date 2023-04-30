// You are given two 0-indexed integer permutations A and B of length n.

// A prefix common array of A and B is an array C such that C[i] is equal to the count of numbers that are present at or before the index i in both A and B.

// Return the prefix common array of A and B.

// A sequence of n integers is called a permutation if it contains all integers from 1 to n exactly once.


import java.util.*;
public class lc2657 {
    

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=A.length;
        int[] ans=new int[n];
        
        
        for(int i=0;i<n;i++){
            
            if(map.containsKey(A[i])){
                int freq=map.get(A[i]);
                freq++;
                map.put(A[i],freq);
            }else{
                map.put(A[i],1);
            }
            
            
             if(map.containsKey(B[i])){
                int freq=map.get(B[i]);
                freq++;
                map.put(B[i],freq);
            }else{
                map.put(B[i],1);
            }
            
            int count=0;
               Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet().iterator();
          
        while(itr.hasNext())
        {
             Map.Entry<Integer, Integer> entry = itr.next();
             if(entry.getValue()==2)
                 count++;
        }
            ans[i]=count;
            
        }
        
        return ans;
        
    }
}
