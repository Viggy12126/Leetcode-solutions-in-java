
// Given a positive integer num, split it into two non-negative integers num1 and num2 such that:

// The concatenation of num1 and num2 is a permutation of num.
// In other words, the sum of the number of occurrences of each digit in num1 and num2 is equal to the number of occurrences of that digit in num.
// num1 and num2 can contain leading zeros.
// Return the minimum possible sum of num1 and num2.

// Notes:

// It is guaranteed that num does not contain any leading zeros.
// The order of occurrence of the digits in num1 and num2 may differ from the order of occurrence of num.

import java.util.*;
class Solution {
    public int splitNum(int num) {
        
         char c[]=String.valueOf(num).toCharArray();
        boolean[] vis=new boolean[c.length];
        Arrays.sort(c);
        
         StringBuilder nm=new StringBuilder();
        StringBuilder kk=new StringBuilder();
        
      for(int i=0;i<c.length;i++){
          
          if(i%2==0){
              nm.append(c[i]);
          }else{
              kk.append(c[i]);
          }
      }
        
             return Integer.parseInt(nm.toString())+Integer.parseInt(kk.toString());
        
        
    }
}
