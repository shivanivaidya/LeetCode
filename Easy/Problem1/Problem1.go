package main

/*
Problem Statement:
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

// twoSum returns indices of two numbers that add up to target
// Time Complexity: O(n) - single pass through array
// Space Complexity: O(n) - storing values in map
func twoSum(nums []int, target int) []int {
    // Create a map to store number -> index mapping
    numMap := make(map[int]int)
    
    // Iterate through array once
    for i, num := range nums {
        // Calculate complement needed
        complement := target - num
        
        // Check if complement exists in map
        if idx, exists := numMap[complement]; exists {
            return []int{idx, i}
        }
        
        // Store current number and its index
        numMap[num] = i
    }
    
    // Return empty slice if no solution found (though problem states there is always one)
    return []int{}
}

func main() {
    // Example usage
    nums := []int{2, 7, 11, 15}
    target := 9
    result := twoSum(nums, target)
    println("Indices:", result[0], result[1])
} 