package main

/*
Problem Statement:
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

// isValid checks if the input string has valid parentheses
// Time Complexity: O(n), Space Complexity: O(n)
func isValid(s string) bool {
    stack := []rune{}
    bracketMap := map[rune]rune{
        ')': '(',
        '}': '{',
        ']': '[',
    }
    for _, char := range s {
        if char == '(' || char == '{' || char == '[' {
            stack = append(stack, char)
        } else {
            if len(stack) == 0 || stack[len(stack)-1] != bracketMap[char] {
                return false
            }
            stack = stack[:len(stack)-1]
        }
    }
    return len(stack) == 0
}

func main() {
    examples := []string{"()", "()[]{}", "(]", "([)]"}
    for _, ex := range examples {
        println("Input:", ex, "Valid:", isValid(ex))
    }
} 