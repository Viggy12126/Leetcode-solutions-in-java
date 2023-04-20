// Given a string word to which you can insert letters "a", "b" or "c" anywhere and any number of times, return the minimum number of letters that must be inserted so that word becomes valid.

// A string is called valid if it can be formed by concatenating the string "abc" several times.


public class lc2645 {
    public int addMinimum(String word) {
    
        int val=0,size=word.length();
               if(word.charAt(0)=='b')
               {
                   val+=1;
               }
               if(word.charAt(0)=='c')
               {
                   val+=2;
               }
               if(word.charAt(size-1)=='b')
               {
                   val+=1;
               }
               if(word.charAt(size-1)=='a')
               {
                   val+=2;
               }
               for(int i=0;i<size-1;i++)
               {
                   char c=word.charAt(i);
                   char d=word.charAt(i+1);
                   if((c=='a' && d=='a') || (c=='b' && d=='b') || (c=='c' && d=='c'))
                   {
                       val+=2;
                   }
                   else if((c=='a' && d=='c') || (c=='b' && d=='a') || (c=='c' && d=='b'))
                   {
                       val+=1;
                   }
               }
               return val;
           }
}
