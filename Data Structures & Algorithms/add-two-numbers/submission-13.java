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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode();
        ListNode cur = head;  
        int sum = 0, carry = 0;

        while (l1 != null || l2 != null) {
            if (l1 == null) sum = l2.val;
            else if (l2 == null) sum = l1.val;
            else sum = l1.val + l2.val;
            sum += carry;

            if (sum >= 10) {
                sum %= 10;
                carry = 1;
            } else carry = 0;

            cur.next = new ListNode(sum);
            cur = cur.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }        

        if (carry == 1) cur.next = new ListNode(carry);

        return head.next;
    }
}
