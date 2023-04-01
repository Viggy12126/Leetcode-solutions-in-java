
// You are given a 0-indexed integer array nums of length n.

// You can perform the following operation as many times as you want:

// Pick an index i that you haven’t picked before, and pick a prime p strictly less than nums[i], then subtract p from nums[i].
// Return true if you can make nums a strictly increasing array using the above operation and false otherwise.

// A strictly increasing array is an array whose each element is strictly greater than its preceding element.

class Solution {
    
    public static boolean isPrime(int n){
     for(int i=2;i<=(int)Math.sqrt(n);i++){
         if(n%i==0){
             return false;
         }
     }
     
 return true;
 }
 
 public boolean primeSubOperation(int[] nums) {
     
     ArrayList<Integer> prime=new ArrayList<>();
     int n=nums.length;
     
      for(int i=2;i<=1000;i++){
         if(isPrime(i)){
             prime.add(i);
         }
     }
     
     Collections.sort(prime);
     
     for(int i=n-2;i>=0;i--){
         
         if(nums[i]>=nums[i+1]){
             
             int count=0;
             
             for(int j=0;j<prime.size();j++){
                 
                 if(nums[i]-prime.get(j)<nums[i+1]){
                     nums[i]-=prime.get(j);
                    
                     
                     if(nums[i]<=0)
                         return false;
                     
                    
                     
                     break;
                 }
                 
                   count++;
             }
             
            if(count==prime.size())
                 return false;
             
         }else{
             continue;
         }
     }
     
     return true;
     
 }
}
