/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

*/

class Problem78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> numberList = new ArrayList<>();
        for(int i = 0; i<nums.length; i++) {
            numberList.add(nums[i]);
        }
        List<List<Integer>> subsetList = new ArrayList<>();
        helper(subsetList, numberList);
        return subsetList;
    }
    
    public void helper(List<List<Integer>> subsetList, List<Integer> numberList) {
        if (numberList.isEmpty()) {
            subsetList.add(new ArrayList<>());
            return;
        }

        int currentNum  = numberList.get(0);
        numberList.remove(0);

        helper(subsetList, numberList);

        List<List<Integer>> iteratingList = new ArrayList<>();
        iteratingList.addAll(subsetList);
        for (List<Integer> subset : iteratingList) {
            List<Integer> newSubset = new ArrayList<>();

            newSubset.addAll(subset);
            newSubset.add(currentNum);

            subsetList.add(newSubset);
        }
    }
}