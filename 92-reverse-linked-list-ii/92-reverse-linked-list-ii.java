/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // get to left
        ListNode curr = dummy;
        ListNode prev = null;
        
        for(int i = 0; i < left; i++) {
            prev = curr;
            curr = curr.next;
        }
        
        //curr is now at left
        ListNode BeforeLeft = prev;
        ListNode LeftNode = curr;
        ListNode temp;
        for(int i = left; i <= right; i++){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        // prev is now at right
        BeforeLeft.next = prev;
        LeftNode.next = curr;
        
        return dummy.next;
        
    }
}