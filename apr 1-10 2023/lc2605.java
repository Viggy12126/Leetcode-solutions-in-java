// Given two arrays of unique digits nums1 and nums2, return the smallest number that contains at least one digit from each array.
class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        
       int ans=100;
        
        for(int i=0;i<nums1.length;i++){
            
            int num1=nums1[i];
            for(int j=0;j<nums2.length;j++){
                
                int num2=nums2[j];
                if(num1==num2){
                    ans=Math.min(ans,num1);
                }else{
                    
                    ans=Math.min(ans,Math.min(num1*10+num2,num2*10+num1));
                    
                }
            }
        }
        
        return ans;
        
    }
}
