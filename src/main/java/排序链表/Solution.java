package 排序链表;

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

    // todo 快速排序的代码，面试点 leetCode超时
    // https://leetcode.cn/problems/sort-list/solutions/1068477/tie-yi-ge-kuai-su-pai-xu-de-dai-ma-mian-36ay1/?page=2
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int pivot = head.val;
        ListNode s = new ListNode(), l = new ListNode();
        ListNode hSmall = s, hLarge = l, node = head.next;
        while (node != null) {
            ListNode next = node.next;
            if (node.val < pivot) {
                // 构建hSmall 为头节点比pivot小的节点
                s.next = node;
                s = s.next;
            } else {
                // 构建hLarge为头节点比pivot大的节点
                l.next = node;
                l = l.next;
            }
            node = next;
        }

        l.next = null;
        s.next = head;
        // 要加上不然hSmall ->head->.......链表无线长
        head.next = null;
        // 注意是hSmall.next
        // hSmall.next->...->small ->head->hLarge.next->....l
        s = sortList(hSmall.next);
        head.next = sortList(hLarge.next);
        return s;
    }

    // TODO 归并排序
    //

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next =  new ListNode(5);
        head.next.next.next.next.next =  new ListNode(7);
        head.next.next.next.next.next.next =  new ListNode(1);
        head.next.next.next.next.next.next.next =  new ListNode(3);
        head.next.next.next.next.next.next.next.next =  new ListNode(9);

        Solution solution = new Solution();
        ListNode listNode = solution.sortList(head);

    }
}