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

        int c=0;
        ListNode cur = head;
        while (cur != null) {
            if (++c == k) break;
            cur = cur.next;
        }
        if (cur == null) return head;


        ListNode prev = null;
        cur = head;
        while (c != 0) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            c--;
        }
        head.next = reverseKGroup(cur, k);

        return prev;
    }
}
