/*

Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Note:

Your algorithm should run in O(n) time and uses constant extra space.

*/

class Problem41 {
    public int firstMissingPositive(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        
        for(int i = 0; i< nums.length; i++) {
            hmap.put(nums[i], i);
        }
        
        for(int i = 1; i <= nums.length+1; i++) {
            if(!hmap.containsKey(i))
                return i;
        }

        return nums.length+1;
    }
}