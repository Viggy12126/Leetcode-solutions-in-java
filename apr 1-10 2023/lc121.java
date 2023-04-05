// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

class Solution {
    public int maxProfit(int[] price) {

        int curr_min=Integer.MAX_VALUE;
        int ans=0;
        for(int i=0;i<price.length;i++){

            if(price[i]<curr_min)
            curr_min=price[i];
            else
            ans=Math.max(ans,price[i]-curr_min);
        }
        
        return ans;
    }
}