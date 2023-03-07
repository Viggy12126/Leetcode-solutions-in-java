// You are given a 2D integer array ranges where ranges[i] = [starti, endi] denotes that all integers between starti and endi (both inclusive) are contained in the ith range.

// You are to split ranges into two (possibly empty) groups such that:

// Each range belongs to exactly one group.
// Any two overlapping ranges must belong to the same group.
// Two ranges are said to be overlapping if there exists at least one integer that is present in both ranges.

// For example, [1, 3] and [2, 5] are overlapping because 2 and 3 occur in both ranges.
// Return the total number of ways to split ranges into two groups. Since the answer may be very large, return it modulo 109 + 7.

import java.util.*;
class Solution {
    public int countWays(int[][] a) {
        
        
          Arrays.sort(a,(b,c)->b[0]-c[0]);
        
        int ans=2;
        int left=a[0][0];
        int right=a[0][1];
            
        for(int i=1;i<a.length;i++){
            int x=a[i][0];
            int y=a[i][1];
            
            if(x>right)
                ans=(ans*2)%(int)(1e9+7);
                // count++;
                
            
            right=Math.max(right,y);
        }
        
        return ans;
    }
}