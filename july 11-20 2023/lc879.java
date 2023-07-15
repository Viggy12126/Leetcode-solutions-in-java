// There is a group of n members, and a list of various crimes they could commit. The ith crime generates 
// a profit[i] and requires group[i] members to participate in it. If a member participates in one crime, 
// that member can't participate in another crime.

// Let's call a profitable scheme any subset of these crimes that generates at least minProfit profit, and the 
//total number of members participating in that subset of crimes is at most n.

// Return the number of schemes that can be chosen. Since the answer may be very large, return it modulo 109 + 7.

class Solution {

    int mod=(int)1e9+7;

    public int f(int i,int j,int k,int people,int minProfit,int[] group,int[] profit,Integer[][][] dp){
       
        if(k>people)
        return 0;

        if(i==group.length){

            if(j>=minProfit && k<=people)
            return 1;

            return 0;
        }

if(dp[i][j][k]!=null)
return dp[i][j][k];

        int op1=f(i+1,j,k,people,minProfit,group,profit,dp);
        int op2=f(i+1,Math.min(j+profit[i],minProfit),k+group[i],people,minProfit,group,profit,dp);

        return dp[i][j][k]= (op1%mod+op2%mod)%mod;

    }
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        
        Integer[][][] dp=new Integer[group.length+1][minProfit+1][n+1];
        return f(0,0,0,n,minProfit,group,profit,dp);
    }
}