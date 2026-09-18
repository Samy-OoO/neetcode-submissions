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
        if (head == null) return false;
        
        ListNode s = head, f = head.next;
        while (s != null && f != null) {
            if (s == f) return true;
            s = s.next;
            f = f.next;
            if (f != null) f = f.next;
        }

        return false;
    }
}
