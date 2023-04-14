// Given an array of integers A of size N and an integer B.

// The College library has N books. The ith book has A[i] number of pages.

// You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.

// A book will be allocated to exactly one student.
// Each student has to be allocated at least one book.
// Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
// Calculate and return that minimum possible number.

// NOTE: Return -1 if a valid assignment is not possible.


import java.util.*;


public class allocate_books {
    
     
    public boolean isPossibe(int[] arr,int n,int bar,int st){
        
        int student=1;
        int pages=0;
        
        for(int i=0;i<n;i++){
            
            if(arr[i]>bar)
            return false;
            
            if(pages+arr[i]>bar){
                pages=arr[i];
                student++;
            }else
            pages+=arr[i];
        }
        
        if(student>st)
        return false;
        
        return true;
    }
    public int books(int[] arr, int st) {
        
        int n=arr.length;
        int sum=0;
        int ans=-1;
        
        Arrays.sort(arr);
        for(int i=0;i<n;i++)
        sum+=arr[i];
        
        int low=arr[0];
        int high=sum;
        
        while(low<=high){
            int mid=(low+high)/2;
            
            if(isPossibe(arr,n,mid,st)){
               
                ans=mid;
                 high=mid-1;
            }else
            low=mid+1;
        }
        
        return ans;
    }
}
