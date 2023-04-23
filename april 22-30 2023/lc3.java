// Given a string s, find the length of the longest 
// substring
//  without repeating characters.


import java.util.*;
public class lc3 {
    public int lengthOfLongestSubstring(String s) {
        
        int n=s.length();

        if(n==0)
        return 0;

        int ans=1;

        Set<Character> set=new HashSet<>();

        for(int i=0;i<n-1;i++){
            set.add(s.charAt(i));
            //  System.out.println(s.charAt(i));
            for(int j=i+1;j<n;j++){

                if(set.contains(s.charAt(j))){
                 ans=Math.max(ans,set.size());
                 set.clear();
                 break;
                }else{
    set.add(s.charAt(j));
    // System.out.println(s.charAt(j));
                }

            }
        }
 ans=Math.max(ans,set.size());
        return ans;
    }
}
