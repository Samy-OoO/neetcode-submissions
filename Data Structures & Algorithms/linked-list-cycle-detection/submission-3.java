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
    public boolean hasCycle(ListNode head) {
        ListNode fast=head, slow=head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) break;
            fast = fast.next;
            if (slow.equals(fast)) return true;
        }
        return false;
    }
}
