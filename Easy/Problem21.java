/*

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Problem21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h3 = new ListNode(-1);
        ListNode l3 = h3;
        
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                    l3.next = l1;
                    l1 = l1.next;
            }
            else {
                    l3.next = l2;
                    l2 = l2.next;
            }
            l3 = l3.next;
        }
        
        l3.next = (l1 == null)? l2 : l1;
        
        return h3.next;
        
    }
}