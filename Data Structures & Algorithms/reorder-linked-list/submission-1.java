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

        ListNode fast=head.next, slow=head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) fast = fast.next;
        }

        ListNode list1 = head;
        ListNode list2 = slow.next;
        slow.next = null;

        ListNode cur = list2, prev = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        list2 = prev;

        ListNode res = head;
        list1 = list1.next;
        while(list1 != null && list2 != null) {
            res.next = list2;
            res = res.next;
            list2 = list2.next;

            res.next = list1;
            res = res.next;
            list1 = list1.next;
        }    

        res.next = (list1 != null) ? list1 : list2;
    }
}
