/*

Given an integer n, return the number of trailing zeroes in n!.

Example 1:

Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Note: Your solution should be in logarithmic time complexity.

*/

class Problem172 {
// 10 is the product of 2 and 5. In n!, we need to know how many 2 and 5, and the number of zeros is the minimum of the     
// number of 2 and the number of 5. Since multiple of 2 is more than multiple of 5, the number of zeros is dominant by 
// the number of 5.
    public int trailingZeroes(int n) {
        int count = 0;
        while(n > 0) {
            count += n/5; 
            n = n/5;
        }
        return count;
    }
}