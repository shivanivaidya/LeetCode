/*

Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

*/

class Problem232 {
    Stack<Integer> forward; 
    Stack<Integer> reverse;

    /** Initialize your data structure here. */
    public Problem232() {
        forward = new Stack<Integer>();
        reverse = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        forward.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        prepForPop();
        int temp = reverse.pop();
        return temp;
    }
    
    /** Get the front element. */
    public int peek() {
        prepForPop();
        return reverse.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (forward.isEmpty() && reverse.isEmpty());
    }
    
    public void prepForPop() {
        if(reverse.isEmpty()) {
            while(!forward.isEmpty()) {
                int temp = forward.pop();
                reverse.push(temp);
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */