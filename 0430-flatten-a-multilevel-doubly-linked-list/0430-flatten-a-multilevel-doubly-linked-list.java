/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node curr = head ;
        while(curr!=null)
        {
            if(curr.child == null)
            {
                curr = curr.next;
            }
            else
            {
                Node child = curr.child;
                Node nextNode = curr.next;
                curr.next = child;
                child.prev = curr;
                curr.child = null ;
                Node temp = child;

                while(temp.next!=null)
                {
                    temp = temp.next;
                }
                 temp.next = nextNode;

                if (nextNode != null) {
                    nextNode.prev = temp;
                }

                curr = curr.next;
            }
        }
        return head;
    }
}