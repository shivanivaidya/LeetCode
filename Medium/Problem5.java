/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"

*/

class Problem5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        int arr[][] = new int[n][n];
        int maxLen = 1;
        String longest = new String();
        
        if(n <= 1) // If s is null or one character long.
            return s;
        
        for(int i = n-1; i>=0; i--) { 
            for(int j = i; j<n; j++) {
                if(i == j) // All strings that are one character long are palindromes.
                    arr[i][j] = 1;
                else if(s.charAt(i) == s.charAt(j)) { // All strings that are two character long and have both characters
                    if(j-i == 1)                      // the same, are palindromes. 
                        arr[i][j] = 1;                
                    else if(arr[i+1][j-1] == 1)       // If n is greater than 2 and characters at i and j are same, 
                        arr[i][j] = 1;                // the string is a palindrome if the inner string is a palindrome.
                    else continue;
                    
                    if(j-i+1>maxLen){  // maxLen is the length of the longest palindromic substring.
                        maxLen = j-i+1; 
                        longest = s.substring(i, j+1); // longest is the longest palindromic substring.
                    }
                }
            }
        }   
        
        if(maxLen == 1) // If no palindromic substring is found, return first character.
            longest = String.valueOf(s.charAt(0));
        return longest;
    }
}
