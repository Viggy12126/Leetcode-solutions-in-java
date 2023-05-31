// Given n non-negative integers representing an elevation map where the width of each bar is 1, 
// compute how much water it can trap after raining.

public class lc42 {
    
    public int trap(int[] height) {
        
        int n=height.length;
        int[] left=new int[n];
        int[] right=new int[n];

        left[0]=-1;
        right[n-1]=-1;

int max=height[0];

        for(int i=1;i<n;i++){
        
        if(height[i]<max){
            left[i]=max;

        }else{
            left[i]=-1;
            max=height[i];
        }
        }


        max=height[n-1];

        for(int i=n-2;i>=0;i--){

              if(height[i]<max){
            right[i]=max;
           }else{
            right[i]=-1;
            max=height[i];
        }
        }


        int ans=0;
        for(int i=0;i<n;i++){

            if(left[i]!=-1 && right[i]!=-1)
            ans+=Math.min(left[i],right[i])-height[i];
        }

        return ans;
    }
}
