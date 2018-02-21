/*

Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?

Related problem: Rotate Array

*/

class Problem186 {
    public void reverseWords(char[] str) {
        // Step 1: reverse the entire str
        reverse(str, 0, str.length-1);
        int start = 0;
        int end = str.length-1;
        int i = 0;
        // Step 2: reverse individual words
        while(i<str.length) {
            if(str[i] == ' ') {
                reverse(str, start, i-1);
                start = i+1;
            }
            i++;
        }
        // Step 3: reverse the last word
        reverse(str, start, str.length-1);   
    }
    
    public void reverse(char[] arr, int start,int end) {
        while(start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}