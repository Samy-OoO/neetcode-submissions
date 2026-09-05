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
    public void reorderList(ListNode head) {
        ListNode slow=head, fast=head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;
        ListNode cur=head2, temp, rev=null;
        while (cur != null) {
            temp = cur.next;
            cur.next = rev;
            rev = cur;
            cur = temp;
        }

        ListNode cur1 = head;
        ListNode cur2 = rev;
        while (cur2 != null) {
            ListNode temp1 = cur1.next;
            ListNode temp2 = cur2.next;

            cur1.next = cur2;
            cur2.next = temp1;

            cur1 = temp1;
            cur2 = temp2;
        }
    }
}
