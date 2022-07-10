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
    public ListNode middleNode(ListNode head) {
        if (head == null) 
            return null;
        
        ListNode slower = head;
        ListNode faster = head;
        
        while(faster != null) {
            if (faster.next == null)
                return slower;
            if (faster.next.next == null)
                return slower.next;
            
            slower = slower.next;
            faster = faster.next.next;
        }
        
        return slower;
    }
}