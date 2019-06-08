/*

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

*/


class Problem15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) {
            return new ArrayList<List<Integer>>();
        }
        
        Arrays.sort(nums);        
        int size = nums.length;
        
        HashSet<List<Integer>> result = new HashSet<List<Integer>>();
        
        for(int i = 0; i < size-2; i++) {
            if(i == 0 || nums[i] != nums[i - 1]) {
                int left = i + 1;
                int right = size - 1;
            
                while(left < right) {
                    int sum = nums[i] + nums[left] + nums[right];

                    if(sum == 0) {
                        List<Integer> group = new ArrayList<Integer>();
                        group.add(nums[i]);
                        group.add(nums[left]);
                        group.add(nums[right]);
                        result.add(group);
                        left++;
                        right--;
                        
                    }
                    else if(sum < 0)
                        left++;
                    else
                        right--;
                }
            }
        }
        return new ArrayList<List<Integer>>(result);
    }
}