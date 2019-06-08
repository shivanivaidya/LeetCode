/*

Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?

*/

class Problem300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0)  
            return 0;
        
        int[] arr = new int[n];
        for(int i = 0; i<n; i++) {
            arr[i] = 1;
        }
        
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<i; j++) {
                if(nums[j] < nums[i]) 
                    arr[i] = Math.max(arr[i], arr[j]+1);
            }
        }
        
        int longest = arr[0];
        for(int i = 0; i<n; i++) {
            if(arr[i] > longest)
                longest = arr[i];
        }
        
        return longest;
    }
}