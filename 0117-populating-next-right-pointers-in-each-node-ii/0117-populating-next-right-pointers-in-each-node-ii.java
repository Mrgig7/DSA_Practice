/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node r) {
        if (r == null) return null;
        Node h = r;
        while (h != null) {
            Node d = new Node(0);
            Node t = d;
            Node c = h;
            while (c != null) {
                if (c.left != null) {
                    t.next = c.left;
                    t = t.next;
                }
                if (c.right != null) {
                    t.next = c.right;
                    t = t.next;
                }
                c = c.next;
            }
            h = d.next;
        }
        return r;
    }
}
