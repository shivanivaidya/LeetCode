"""
Problem Statement:
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
"""

def is_valid(s: str) -> bool:
    """
    Checks if the input string has valid parentheses.
    Time Complexity: O(n), Space Complexity: O(n)
    """
    stack = []
    bracket_map = {')': '(', '}': '{', ']': '['}
    for char in s:
        if char in '({[':
            stack.append(char)
        else:
            if not stack or stack[-1] != bracket_map.get(char):
                return False
            stack.pop()
    return not stack

if __name__ == "__main__":
    examples = ["()", "()[]{}", "(]", "([)]"]
    for ex in examples:
        print(f"Input: {ex} Valid: {is_valid(ex)}") 