package 删除排序链表中的重复元素2;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        // 判断是否头节点和有重复情况
        boolean b =false;
        // 处理头节点重复情况
        while (head.next!=null&&head!=null&&head.val == head.next.val) {
            b = true;
            head = head.next;
        }
        if (b&&head.next != null) {
            head = head.next;
            return deleteDuplicates(head);
        } else if(b&&head.next == null){
            return null;
        }

        // 非头节点重复情况
        // 前节点
        ListNode p = null;
        // 当前
        ListNode c = head;
        // 后节点
        ListNode n = head.next;

        while (c != null) {
            if (n != null && c.val == n.val) {
                // p 不可能为空
                // 1，2 情况不进入
                // 1，1，2，2 情况前面已处理
                p.next = deleteDuplicates(c);
                c = deleteDuplicates(c);;
                if (c != null) {
                    n = c.next;
                } else {
                    n = null;
                }
            } else {
                p = c;
                c = n;
                if (n != null) {
                    n = n.next;
                } else {
                    n = null;
                }
            }

        }
        return head;
    }


    // todo 大佬代码
    public ListNode deleteDuplicates1(ListNode head){

        // 大佬合并代码
        if (head == null||head.next == null) {
            return head;
        }

        // 后节点
        ListNode n = head.next;

        //如果是这种情况
        //      1 --> 1 --> 1 --> 2 --> 3
        //     head  next
        //1.则需要移动next直到出现与当前head.value不相等的情况（含null）
        //2.并且此时的head已经不能要了，因为已经head是重复的节点
        //--------------else-------------
        //      1 --> 2 --> 3
        //     head  next
        //3.如果没有出现1的情况，则递归返回的节点就作为head的子节点
        if(head.val==n.val){
            while(n!=null&&n.val==head.val){
                n = n.next;
            }
            head = deleteDuplicates1(n);
        }
        else{
            head.next = deleteDuplicates1(n);
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
        solution.deleteDuplicates(head);
        ListNode result = solution.deleteDuplicates(head);
    }
}

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