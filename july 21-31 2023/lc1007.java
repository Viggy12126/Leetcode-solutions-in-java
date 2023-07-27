// In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. 
// (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

// We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.

// Return the minimum number of rotations so that all the values in tops are the same, or all the values in 
// bottoms are the same.

// If it cannot be done, return -1.

public class lc1007 {
    
    public int fun(int[] arr1,int[] arr2,int tar){

        int flips=0;

        for(int i=0;i<arr1.length;i++){

            if(tar==arr1[i])
            continue;
            else if(tar==arr2[i])
            flips++;
            else
            return Integer.MAX_VALUE;
        }

        return flips;
    }
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
    int top=tops[0];
    int bot=bottoms[0];

    int ans=Integer.MAX_VALUE;
    ans=Math.min(ans,fun(tops,bottoms,top));
    ans=Math.min(ans,fun(bottoms,tops,bot));
    ans=Math.min(ans,fun(bottoms,tops,top));
    ans=Math.min(ans,fun(tops,bottoms,bot));

    // System.out.println(tops.length+" "+bottoms.length);

    if(ans==Integer.MAX_VALUE)
    return -1;

    return ans;

    }
}
