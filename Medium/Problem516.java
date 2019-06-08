/*

Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:

"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".

*/

class Problem516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int arr[][] = new int[n][n];
        
        for(int i = n-1; i>=0; i--) {
            for(int j = i; j<n; j++) {
                if(i == j)
                    arr[i][j] = 1;
                else if(s.charAt(i) == s.charAt(j))
                    arr[i][j] = arr[i+1][j-1] + 2;
                else
                    arr[i][j] = Math.max(arr[i+1][j], arr[i][j-1]);
            }
        }
        
        return arr[0][n-1];
    }
}