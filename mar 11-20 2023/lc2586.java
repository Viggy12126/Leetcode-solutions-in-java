
// You are given a 0-indexed array of string words and two integers left and right.

// A string is called a vowel string if it starts with a vowel character and ends with a vowel character where vowel characters are 'a', 'e', 'i', 'o', and 'u'.

// Return the number of vowel strings words[i] where i belongs to the inclusive range [left, right]

class Solution {
    
    public boolean isVowel(char ch){
        
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
            return true;
        
        return false;
    }
    public int vowelStrings(String[] words, int left, int right) {
        
        int ans=0;
        
        for(int i=left;i<=right;i++){
            String word=words[i];
            char first=word.charAt(0);
            char sec=word.charAt(word.length()-1);
            
            if(isVowel(first) && isVowel(sec))
                ans++;
        }
        
        return ans;
        
    }
}