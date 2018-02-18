/**
Reverse a Singly Linked List.

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Problem206 {
    public ListNode reverseList(ListNode head) {
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