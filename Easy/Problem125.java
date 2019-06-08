/*

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false

*/

class Problem125 {
    public boolean isPalindrome(String s) {
        int n = s.length();
        if(n == 0) return true;
        
        int left = 0;
        int right = n - 1;
        
        while(left < right) {
            char ch1 = s.charAt(left);
            char ch2 = s.charAt(right);
            
            if(isLetterOrDigit(ch1) && isLetterOrDigit(ch2)) {
                if(Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) 
                    return false;
                left++;
                right--;
            }
            else if(!isLetterOrDigit(ch1))
                left++;
            else if(!isLetterOrDigit(ch2))
                right--;
        }
        return true;
    }
    
    private boolean isLetterOrDigit(char c) {
        return (c >= 'a' && c <= 'z') ||
               (c >= 'A' && c <= 'Z') ||
               (c >= '0' && c <= '9');
    }
}