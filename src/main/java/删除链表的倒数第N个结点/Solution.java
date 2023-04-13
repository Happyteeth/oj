package 删除链表的倒数第N个结点;

/**
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
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

    // 统计节点数，相减顺序查找
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode p = null;
        ListNode c = head;
        ListNode next = head.next;
        int i = 0;
        while (c != null) {
            i++;
            p = c;
            c = next;
            if (next != null) {
                next = next.next;
            }
        }
        // 顺序删除数
        int t = i - n;
        if (t == 0 && i == 1) {
            return null;
        }
        else {
            int j = 0;
            p = null;
            c = head;
            next = head.next;
            if(t==0){
                head = head.next;
            }else{
                while (j != t) {
                    j++;
                    p = c;
                    c = next;
                    if (next != null) {
                        next = next.next;
                    }
                }

                p.next = next;
            }

        }

        return head;
    }

    // todo 有时间研究
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        // 虚头部，防止删除后链表为空
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode slow = head;
        ListNode fast = head;

        while(n>0&&fast!=null){
            fast = fast.next;
            n--;
        }
        // 可能删除的是slow 节点pre->slow->...(n)->fast(null)
        ListNode pre = dummyHead;
        // 快慢指针一起走
        while(fast!=null){
            fast = fast.next;

            pre = slow;
            slow = slow.next;
        }
        pre.next = slow.next;
        slow.next = null;

        return dummyHead.next;
    }

    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        // 记录fast的前一个节点 ，用于判断是否删除头节点
        ListNode fastP = head;
        // n==0 确保 slow 和 fast之间存在n个节点
        // 不把fast!=nul作为判断条件 以防止【1】 1 情况，fastP =1，不为空
        while(n>=0){
            fastP = fast;
            // 情况
            // 当fast为空时，直接赋值null 判断
            if(fast!=null){
                fast = fast.next;
            }else{
                fast = null;
            }

            n--;
        }
        // 1，2，3，4，5   5情况fastP为空
        if(fastP==null){
            head = head.next;
        }else{
            while(fast!=null){
                slow = slow.next;
                fast = fast.next;
            }
            // 1,2,3,4,5  2 情况 1,2,3,5
            if(slow.next!=null){
                slow.next = slow.next.next;
            }
            else{
                // 1,2,3,4,5 1 1情况直接删除最后一个
                slow.next = null;
            }

        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next =  new ListNode(4);
//        head.next.next.next.next.next =  new ListNode(4);
//        head.next.next.next.next.next.next =  new ListNode(5);
        Solution solution = new Solution();
        solution.removeNthFromEnd(head,1);
    }
}