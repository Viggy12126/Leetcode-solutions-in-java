// A conveyor belt has packages that must be shipped from one port to another within days days.

// The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

// Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days

class Solution {

    public boolean isPossible(int mid,int[] arr,int days){

int count=1;
        int sum=0;
        int n=arr.length;

        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum>mid){
                count++;
                sum=arr[i];
            }
        }

        if(count<=days)
        return true;

        return false;
    }
    public int shipWithinDays(int[] arr, int days) {
        
        int high=0;
        int low=0;
        int ans=0;
        int n=arr.length;

        for(int i=0;i<n;i++){
            high+=arr[i];
            low=Math.max(low,arr[i]);
        }

        while(low<=high){
            int mid=low+(high-low)/2;

            if(isPossible(mid,arr,days)){
                ans=mid;
                high=mid-1;
            }
else
            low=mid+1;
        }

        return ans;



    }
}
