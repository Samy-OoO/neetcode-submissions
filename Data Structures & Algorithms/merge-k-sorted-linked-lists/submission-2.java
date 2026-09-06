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
    public ListNode mergeKLists(ListNode[] lists) {

        int n = lists.length;
        if (n == 0) return null;
        else if (n == 1) return lists[0];
        
        ListNode[] nodeArray;
        if (n%2 == 0) nodeArray = new ListNode[n/2];
        else nodeArray = new ListNode[n/2 + 1];

        for (int i=0; i<n; i+=2) {
            ListNode left = lists[i];
            ListNode right = (i+1 < n) ? lists[i+1] : null;

            nodeArray[i/2] = merge(left, right);
        }

        ListNode node = mergeKLists(nodeArray);

        return node;
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) return right;
        else if (right == null) return left;
        
        ListNode cur1=left, cur2=right, res;        

        if (cur1.val <= cur2.val) {
            res = cur1;
            cur1 = cur1.next;
        } else {
            res = cur2;
            cur2 = cur2.next;
        }

        ListNode cur = res;

        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }

        cur.next = (cur1 != null) ? cur1 : cur2;

        return res;
    }
}
