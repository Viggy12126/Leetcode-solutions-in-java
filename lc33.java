// There is an integer array nums sorted in ascending order (with distinct values).

// Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

// Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

// You must write an algorithm with O(log n) runtime complexity.

 


class Solution {

    public int binarySearch2(int[] nums,int left,int right,int tar){
          
          while(left<=right){
               int mid=left + (right - left) / 2;
            //    System.out.println(mid);

               if(nums[mid]>tar){
            right=mid-1;
               }else if(nums[mid]<tar){
left=mid+1;
               }else{
                   return mid;
               }
          }

          return -1;
    }



    public int binarySearch1(int[] nums,int left,int right,int tar){
          
          while(left<=right){
               int mid=left + (right - left) / 2;

               if(nums[mid]>tar){
            right=mid-1;
               }else if(nums[mid]<tar){
left=mid+1;
               }else{
                   return mid;
               }
          }

          return -1;
    }

    public int findPivot(int[] nums){

        int left=0;
        int right=nums.length-1;

        while(left<right){
            int mid=left + (right - left) / 2;
            //  System.out.println(mid);

            if(nums[mid]<nums[right])
            right=mid;
            else
            left=mid+1;

        }

        return left;
    }
    public int search(int[] nums, int target) {

        if(nums.length==1){

            if(nums[0]==target)
            return 0;

            return -1;
        }
        
        int index=findPivot(nums);
        // System.out.println(index);

        int bs1=binarySearch1(nums,0,index-1,target);
        int bs2=binarySearch2(nums,index,nums.length-1,target);

        if(bs1==-1 && bs2==-1)
        return -1;
        else if(bs1!=-1 && bs2==-1)
        return bs1;
     
        return bs2;
    }
}
