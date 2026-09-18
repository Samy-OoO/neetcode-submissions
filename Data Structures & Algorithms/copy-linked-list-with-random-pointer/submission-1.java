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
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        } 

        for (Map.Entry<Node, Node> entry : map.entrySet()) {
            Node oldNode = entry.getKey();
            Node newNode = entry.getValue();
            newNode.next = map.get(oldNode.next);
            newNode.random = map.get(oldNode.random);
        }

        return map.get(head);
    }
}
