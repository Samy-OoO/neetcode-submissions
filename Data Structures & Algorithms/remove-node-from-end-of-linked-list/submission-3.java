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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur=head;
        int count=0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }

        if (count == n) {
            return head.next;
        }
        
        cur = head;
        while (cur != null) {
            if (--count == n) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }

        return head;
    }
}
