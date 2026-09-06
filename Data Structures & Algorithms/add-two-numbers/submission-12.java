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

        ListNode res = new ListNode(0);
        ListNode cur = res;
        int sum, val, carry = 0;
        boolean tens;
        
        while (l1 != null || l2 != null) {

            if (l1 == null) sum = l2.val + carry;
            else if (l2 == null) sum = l1.val + carry;
            else sum = l1.val + l2.val + carry;

            tens = (sum >= 10);
            val = (tens) ? sum%10 : sum;

            ListNode node = new ListNode(val);
            cur.next = node;
            cur = cur.next;
            
            l1 = (l1 != null) ? l1.next : l1;
            l2 = (l2 != null) ? l2.next : l2;

            carry = (tens) ? 1 : 0;
        }

        if (carry != 0) {
            ListNode node = new ListNode(carry);
            cur.next = node;
        } 

        return res.next;
        
    }
}
