public class edit_distance {
    
    public int f(int i,int j,String s1,String s2,Integer[][]dp){

        if(i<0)
        return j+1;
        
        if(j<0)
        return i+1;
        
        if(dp[i][j]!=null)
        return dp[i][j];
        
             if(s1.charAt(i)==s2.charAt(j))
             return dp[i][j]= f(i-1,j-1,s1,s2,dp);
             else{
                 int op1=1+f(i,j-1,s1,s2,dp);//insert
                 int op2=1+f(i-1,j,s1,s2,dp);//delete
                 int op3=1+f(i-1,j-1,s1,s2,dp);//replace
        
                 return dp[i][j]= Math.min(op2,Math.min(op1,op3));
             }
            }
            public int minDistance(String word1, String word2) {
                
                int[][]dp=new int[word1.length()+1][word2.length()+1];
                int n=word1.length();
                int m=word2.length();
                // return f(word1.length()-1,word2.length()-1,word1,word2,dp);
        
                for(int i=0;i<=n;i++)
                dp[i][0]=i;
        
                for(int j=0;j<=m;j++)
                dp[0][j]=j;
        
                for(int i=1;i<=n;i++){
                    for(int j=1;j<=m;j++){
                         if(word1.charAt(i-1)==word2.charAt(j-1)){
                           dp[i][j]=dp[i-1][j-1];
        
                         }else{
         int op1=1+dp[i][j-1];//insert
                 int op2=1+dp[i-1][j];//delete
                 int op3=1+dp[i-1][j-1];//replace
        
                 dp[i][j]= Math.min(op2,Math.min(op1,op3));
                        
                         }
                    }
                }
                return dp[n][m];
            }
}
