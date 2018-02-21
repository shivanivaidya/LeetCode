/*

Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

*/

class Problem219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i = 0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                return true;
            }
            else {
                map.put(nums[i], 1);
                if(map.size() > k) {
                    map.remove(nums[i-k]);
                }    
            }
        }
        return false;    
    }
}