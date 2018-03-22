/*

Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".

*/

class Problem344 {
    public String reverseString(String s) {
        int n = s.length();
        char[] str = s.toCharArray();
        for(int i = 0; i<n/2; i++) {
            swap(str, i, n-1-i);
        }
        return String.valueOf(str);
    }
    
    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}