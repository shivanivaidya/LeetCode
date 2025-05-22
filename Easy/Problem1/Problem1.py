"""
Problem Statement:
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
"""

def two_sum(nums: list[int], target: int) -> list[int]:
    """
    Returns indices of two numbers that add up to target.
    
    Args:
        nums: List of integers
        target: Target sum to find
        
    Returns:
        List of two indices whose corresponding numbers sum to target
        
    Time Complexity: O(n) - single pass through array
    Space Complexity: O(n) - storing values in dictionary
    """
    # Dictionary to store number -> index mapping
    num_dict = {}
    
    # Iterate through array once
    for i, num in enumerate(nums):
        # Calculate complement needed
        complement = target - num
        
        # Check if complement exists in dictionary
        if complement in num_dict:
            return [num_dict[complement], i]
        
        # Store current number and its index
        num_dict[num] = i
    
    # Return empty list if no solution found (though problem states there is always one)
    return []

# Example usage
if __name__ == "__main__":
    nums = [2, 7, 11, 15]
    target = 9
    result = two_sum(nums, target)
    print(f"Indices: {result}") 