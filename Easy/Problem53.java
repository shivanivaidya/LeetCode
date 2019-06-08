/*

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

*/

class Problem53 {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = nums[0];
        
        for(int i = 0; i<nums.length; i++) {
            if(sum < 0) {
                sum = nums[i];
            }
            else {
                sum += nums[i];
            }
            
            if(maxSum < sum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}