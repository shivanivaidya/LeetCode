/*

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

*/

class Problem46 {
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();
       // Arrays.sort(nums); // not necessary
       backtrack(result, new ArrayList<>(), nums);
       return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int [] nums) {
        if(tempList.size() == nums.length) {
          result.add(new ArrayList<>(tempList));
          return;
        }
        for(int i = 0; i < nums.length; i++){ 
            if(tempList.contains(nums[i])) continue; // element already exists, skip
            tempList.add(nums[i]);
            backtrack(result, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    } 
}