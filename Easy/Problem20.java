/*

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

*/

class Problem20 {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        if(s.length() % 2 != 0) {
            return false;
        }
        for(int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '{' || ch == '[' || ch == '(') {
                st.push(ch);
            }
            else if(!st.isEmpty()) {
                char ch1 = st.peek();
                switch(ch) {
                    case '}': if(ch1 == '{') {
                                 st.pop();
                              }
                              break;
                    case ')': if(ch1 == '(') {
                                 st.pop();
                              }
                              break;
                    case ']': if(ch1 == '[') {
                                 st.pop();
                              }
                              break;
                }
            }
        }
        if(!st.isEmpty()) {
            return false;
        }
        else {
            return true; 
        }
    }
}



