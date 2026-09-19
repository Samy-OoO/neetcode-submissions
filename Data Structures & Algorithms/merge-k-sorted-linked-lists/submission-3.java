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
        int len = lists.length;
        if (len == 0) return null;
        if (len == 1) return lists[0];
        int size = (len % 2 == 0) ? len/2 : len/2 + 1;
        
        ListNode[] nodeArray = new ListNode[(int) Math.ceil(size)];

        for (int i=0; i<len; i+=2){
            nodeArray[i/2] = (i+1 < len) ? merge(lists[i], lists[i+1]) : lists[i];
        }

        return mergeKLists(nodeArray);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode newArray = new ListNode(0);
        ListNode head = newArray;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                newArray.next = left;
                left = left.next;
            } else {
                newArray.next = right;
                right = right.next;
            }
            newArray = newArray.next;
        }
        newArray.next = (left != null) ? left : right;
        return head.next;
    }
}
