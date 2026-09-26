/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        
        Map<Node, Node> refMap = new HashMap<>();
        Queue<Node> q = new ArrayDeque<>();
        q.offer(node);
        refMap.put(node, new Node(node.val));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (Node neighbor : cur.neighbors) {
                if (!refMap.containsKey(neighbor)) {
                    q.offer(neighbor);
                    refMap.put(neighbor, new Node(neighbor.val));
                }
                refMap.get(cur).neighbors.add(refMap.get(neighbor));
            }
            
        }

        return refMap.get(node);
    }
}