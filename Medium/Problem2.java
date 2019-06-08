/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
class Problem2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int carry = 0;
        
        ListNode l3 = new ListNode(-1);
        ListNode head = l3;
        while(l1 != null || l2 != null) {
            int d1 = 0;
            int d2 = 0;
            
            if(l1 != null) {
                d1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                d2 = l2.val;
                l2 = l2.next;
            }
            
            sum = carry + d1 + d2;
            carry = sum / 10;
            l3.next = new ListNode(sum % 10);
            l3 = l3.next;
        }
        if(carry != 0)
            l3.next = new ListNode(carry);
        
        return head.next;
    }
}