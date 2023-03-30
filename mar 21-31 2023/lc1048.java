// You are given an array of words where each word consists of lowercase English letters.

// wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.

// For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
// A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.

// Return the length of the longest possible word chain with words chosen from the given list of words.

import java.util.*;

class SortbyLen implements Comparator<String> { 
    public int compare(String a, String b) 
    { 
        return a.length() - b.length(); 
    } 
} 



class Solution {

    boolean isPredecessor(String str1,String str2){

    int l1=str1.length();
    int l2=str2.length();

    if(l1!=l2+1)
    return false;

    int i=0;
    int j=0;

    while(i<l1){

        if(j<l2 && str1.charAt(i)==str2.charAt(j)){
            i++;
            j++;
        }else
        i++;
    }

    if(i==l1 && j==l2)
    return true;

    return false;
}
    public int longestStrChain(String[] words) {
        
        int n=words.length;
        Arrays.sort(words,new SortbyLen());
        int maxi=1;

        int[] dp=new int[n];
          Arrays.fill(dp , 1);

        for(int i=1;i<n;i++){
            int max=1;
            
       for(int j=0;j<i;j++){

           if(isPredecessor(words[i],words[j])){
               max=Math.max(max,dp[j]);
                dp[i]=max+1;
           }
       }
      
       
       maxi=Math.max(maxi,dp[i]);
        }


// for(int i=0;i<n;i++){
//     System.out.println(dp[i]);
// }
        return maxi;
    }
}
