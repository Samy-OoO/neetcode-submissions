/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            Node node = new Node(cur.val);
            map.put(cur, node);
            cur = cur.next;
        }

        for (Map.Entry<Node, Node> entry: map.entrySet()) {
            Node node = entry.getValue();
            Node ogNode = entry.getKey();
            node.next = map.get(ogNode.next);
            node.random = map.get(ogNode.random);
        }

        Node head2 = map.get(head);

        return head2;
        
    }
}










