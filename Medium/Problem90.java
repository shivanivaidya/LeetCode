/*

Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

*/

class Problem90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // Because sometimes, the input is not sorted but it 
                           // needs to be since we are checking if consecutive elemets are repeating.
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, nums, 0);
        return result;
    }
    
    private int helper(List<List<Integer>> result, int[] nums, int index) { // index keeps track of the element in the array.
        if(index == nums.length) {
            result.add(new ArrayList<>());
            return 0;
        }   
       
        int current = nums[index]; // current is the element that gets combined with the other elements in result.
        int currentIndex = index;  // currentIndex stores the index of the current element because by the time the recursive call
                                   // returns, the index variable holds the last index.
        index++;
        
        int count = helper(result, nums, index); // If an element repeats, we are only supposed to combine it with those elements
                                                 // in result that were added in the previous recursion with the previous
                                                 // element. count keeps track of how many elements were added to result in the
                                                 // previous recursion.
        
        List<List<Integer>> iteratingList = new ArrayList<List<Integer>>(result); // We cannot iterate directly over result 
                                                                                  // because iterating over and adding elements
                                                                                  // to result leads to a
                                                                                  // ConcurrentModificationException.
        int currlen = result.size(); // Stores the current length of result.
        int i = 0; // Used to iterate over result.
        
        if(currentIndex < nums.length-1 && current == nums[currentIndex+1]) // If an element repeats, set i to count so that
            i = count;                                                      // current will combine with only new elements.
        else                                                                // Else, set count to 0.
            count = 0;
            
        while(i<currlen) {
            List<Integer> subset = iteratingList.get(i);  
            List<Integer> newSubSet = new ArrayList<Integer>(subset);
            newSubSet.add(current);
            result.add(newSubSet);
            i++;
            count++;
        }
        return count;
    }
}
