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
        if (head == null || head.next == null) return false;

        ListNode f = head, s = head;
        while (f != null && s != null) {
            s = s.next;
            f = f.next;
            if (f != null) f = f.next;
            if (f == s) return true;
        }

        return false;
    }
}
