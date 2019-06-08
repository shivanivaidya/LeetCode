/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/



class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
        
        int i = 0;
        int n = s.length();
        int maxLen = 0;
        
        for(int j = 0; j<n; j++) {
            if(hmap.containsKey(s.charAt(j))) {
                i = Math.max(i, hmap.get(s.charAt(j)));
            }
            maxLen = Math.max(maxLen, j-i+1);   
            hmap.put(s.charAt(j), j+1);
        }
        return maxLen;
    }
}