import java.util.Arrays;
import java.util.Comparator;

public class longest_string_chain {
    
    class SortbyLen implements Comparator<String> { 
    public int compare(String a, String b) 
    { 
        return a.length() - b.length(); 
    } 
}

boolean isPredecessor(String str1,String str2){

    int l1=str1.length();
    int l2=str2.length();

    if(l1!=l2+1)
    return false;

    int i=0;
    int j=0;

    while(i<l1){

        if(j<l2 && str1.charAt(i)==str2.charAt(j)){
            i++;
            j++;
        }else
        i++;
    }

    if(i==l1 && j==l2)
    return true;

    return false;
}
    public int longestStrChain(String[] words) {
        
        int n=words.length;
        Arrays.sort(words,new SortbyLen());
        int maxi=1;

        int[] dp=new int[n];
          Arrays.fill(dp , 1);

        for(int i=1;i<n;i++){
            int max=1;
            
       for(int j=0;j<i;j++){

           if(isPredecessor(words[i],words[j])){
               max=Math.max(max,dp[j]);
                dp[i]=max+1;
           }
       }
      
       
       maxi=Math.max(maxi,dp[i]);
        }


// for(int i=0;i<n;i++){
//     System.out.println(dp[i]);
// }
        return maxi;
    }
}
