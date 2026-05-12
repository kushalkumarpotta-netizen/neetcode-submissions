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

        if(head == null)
        {
            return null;
        }
        
        Node dummy = new Node(0);
        Node tail = dummy;
        Node l1 = head;
        HashMap<Node,Node> map = new HashMap<>();

        while(l1!=null)
        {
            Node add = new Node(l1.val);
            map.put(l1,add);
            tail.next = add;
            tail = tail.next;
            l1 = l1.next;
        }
        tail.next = null;

        l1 = head;

        while(l1!=null)
        {
            Node copy = map.get(l1);

            copy.random = map.get(l1.random);
            l1 = l1.next;
        }
        return dummy.next;
    }
}
