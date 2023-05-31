// Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, 
// or -1 if needle is not part of haystack

public class lc28 {
    
    public int strStr(String haystack, String needle) {

        int needle_length=needle.length();
         int haystack_length=haystack.length();
        
        int lim=haystack_length-needle_length;

        for(int i=0;i<=lim;i++){
             
             String str=haystack.substring(i,i+needle_length);
            //  System.out.println(str);
             if(str.equals(needle))
             return i;
        }

        return -1;
        
 
        
    }
}
