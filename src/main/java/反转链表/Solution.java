package 反转链表;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = null;
        ListNode c = head;
        ListNode n = head.next;
        while (c != null) {
            // null->2->0->1->3
            // p=2->null, c= 0->1->3, n=1->3
            // p 在重建p->c之间的关系，c->n在维护原来的关系
            c.next = p;
            p = c;
            c = n;

            if (n != null) {
                n = n.next;
            }

        }
        return p;
    }

    public static void main(String[] args) {
     ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(0);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(3);
        Solution solution = new Solution();
        solution.reverseList(listNode);
    }
}