// Given two strings text1 and text2, return the length of their longest common subsequence. If there is 
// no common subsequence, return 0.

// A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

// For example, "ace" is a subsequence of "abcde".
// A common subsequence of two strings is a subsequence that is common to both strings.


public class lc1143 {
    
//     public int helper(String s1,String s2,int i,int j,Integer[][] dp){

//         if(i==0 || j==0)
//         return 0;

// if(dp[i][j]!=null)
// return dp[i][j];

//         if(s1.charAt(i-1)==s2.charAt(j-1))
//         return dp[i][j]=1+helper(s1,s2,i-1,j-1,dp);

//         return dp[i][j]=Math.max(helper(s1,s2,i-1,j,dp),helper(s1,s2,i,j-1,dp));
//     }
public int longestCommonSubsequence(String s1, String s2) {
        
    int n=s1.length();
    int m=s2.length();
  int[][] dp=new int[n+1][m+1];

    // return helper(text1,text2,n,m,dp);

    for(int i=0;i<=n;i++)
    dp[i][0]=0;

    for(int j=0;j<=m;j++)
    dp[0][j]=0;

    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
if(s1.charAt(i-1)==s2.charAt(j-1))
dp[i][j]=1+dp[i-1][j-1];
else
dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
        }
    }

    return dp[n][m];
}

}