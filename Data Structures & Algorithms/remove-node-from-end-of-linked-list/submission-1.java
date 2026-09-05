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

        cur = head;
        while (cur != null) {
            if (cur == head && count == n) head = head.next;
            if (--count == n) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }

        return head;
    }
}
