/*

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

*/

class Problem33 {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end)/2;
            if(nums[mid] == target) {
                return mid;
            }
            
            if(nums[start] <= nums[mid]) {
                if(nums[start] <= target && target < nums[mid]) {
                    end = mid-1;
                }
                else {
                    start = mid+1;
                }
            }
            
            if(nums[mid] <= nums[end]) {
                if(nums[mid] < target && target <= nums[end]) {
                    start = mid+1;
                }
                else {
                    end = mid-1;
                }
            }
        }
        
        return -1;
        
    }
}
