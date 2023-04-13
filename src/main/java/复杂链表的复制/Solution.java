package 复杂链表的复制;


import java.util.HashMap;
import java.util.Map;

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

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return head;
        }
        Node cur = head;
        
        Node newP = null;
        Node newC = new Node(head.val);
        Node newHead = newC;
        cur = cur.next;
        // 单向链表的复制
        while(cur!=null){
            newP = newC;
            newC = new Node(cur.val);
            cur = cur.next;
            newP.next = newC;
        }
        cur = head;
        newC = newHead;
        // 复制ramdow 节点
        while(cur!=null){
            Node r = cur.random;
            Node cN = head;
            Node ncN = newHead;
            while(cN!=r){
                cN = cN.next;
                ncN = ncN.next;
            }
            newC.random = ncN;
            cur = cur.next;
            newC = newC.next;
        }

        return newHead;
    }
    public Node copyRandomList1(Node head) {
        if(head==null){
            return head;
        }
        Node cur = head;

        Node newP = null;
        Node newC = new Node(head.val);
        Node newHead = newC;
        Map<Node,Node> map = new HashMap();
        map.put(cur,newC);
        cur = cur.next;
        // 单向链表的复制
        while(cur!=null){
            newP = newC;
            newC = new Node(cur.val);
            newP.next = newC;
            map.put(cur, newC);
            cur = cur.next;
        }
        cur = head;
        newC = newHead;
        while(cur!=null){
            Node r = cur.random;
            newC.random = map.get(r);
            cur = cur.next;
            newC = newC.next;
        }

        return newHead;
    }
}