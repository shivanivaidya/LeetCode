/*

Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
class Problem234 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode head2 = reverse(slow);
        
        ListNode c1 = head, c2 = head2;
        
        while(c2 != null) {
            if(c1.val != c2.val)
                return false;
            c1 = c1.next;
            c2 = c2.next;
        }
        
        return true;
    }
       
    
    public ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null, next = null;
        
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
}