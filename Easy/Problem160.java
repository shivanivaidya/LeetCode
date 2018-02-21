/*

Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
public class Problem160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        
        int diff = Math.abs(lenA-lenB);
        
        if(lenA > lenB) {
            headA = moveAhead(headA, diff);
        }
        else {
            headB = moveAhead(headB, diff);
        }
        
        ListNode c1 = headA;
        ListNode c2 = headB;
        
        while(c1 != null) {
            if(c1 == c2) 
                return c1;
            c1 = c1.next;
            c2 = c2.next;
        }
        
        return null; 
    }
       
    public int getLength(ListNode head) {
        ListNode current = head;
        int count = 0;
           
        while(current != null) {
            count++;
            current = current.next;
        }
           
        return count;
    }
    
    public ListNode moveAhead(ListNode head, int diff) {
        int i = 1;
        while(i <= diff) {
            head = head.next;
            i++;
        }
        return head;
    }
}
