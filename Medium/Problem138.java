/*

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

 

Example 1:



Input:
{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

Explanation:
Node 1's value is 1, both of its next and random pointer points to Node 2.
Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 

Note:

You must return the copy of the given head as a reference to the cloned list.

*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */


public class Problem138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode p = head;
        RandomListNode nextEl;
        while(p!=null) {
            nextEl = p.next;
            RandomListNode copy = new RandomListNode(p.label);
            p.next = copy;
            copy.next = nextEl;
            p = nextEl;
        }
        
        p = head;
        while(p!=null) {
            if(p.random!=null) {
                p.next.random = p.random.next;
            }
            p=p.next.next;
        }
        p = head;
        RandomListNode pseudoHead = new RandomListNode(0);        
        RandomListNode copyIter = pseudoHead;
        RandomListNode copy;

        while (p!= null) {
            nextEl = p.next.next;
            // extract the copy
            copy = p.next;
            copyIter.next = copy;
            copyIter = copy;
            // restore the original list
            p.next = nextEl;
            p = nextEl;
        }

        return pseudoHead.next;
  }
}