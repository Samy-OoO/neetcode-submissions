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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;

        int count = 0;
        ListNode cur = head;
        while (cur != null && count != k) {
            count++;
            cur = cur.next;
        }
        if (count < k) return head;

        cur = head;
        ListNode prev = null;
        while (count != 0) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            count--;
        }

        head.next = reverseKGroup(cur, k);
        return prev;
                
    }
}
