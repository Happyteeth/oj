package 链表中环的入口节点;


  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode node = slow;
        while(slow!=null){
            if(fast==null){
                return null;
            }
            slow = slow.next;
            fast = fast.next;
            // 环里面最少差1个节点可以重复 1->2->1
            if(fast!=null){
                fast = fast.next;
            }else{
                return null;
            }
            // TODO 不能用值相等判断 -1,-7,7,-4,19,6,-9,-5,-2,-5 9  可能值相同
            if(slow==fast){
                // node 一定在环中
                node = slow;
                break;
            }

        }
        // 环的个数
        int n = 0;
        ListNode newNode = node;
        node = node.next;
        while(newNode!=node){
            node = node.next;
            n++;
        }
        // 3-4-5-6 n=3, 3-4-5-6-3 n=4
        fast = head;
        slow = head;
        while(n>=0){
            fast = fast.next;
            n--;
        }
        // 1，2，3，4，5，3，4，5   1，2，3，4  2，3，4，5。。。。4，5，3，4
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
    public ListNode detectCycle1(ListNode head) {
        if(head == null || head.next == null) return null; // 特判
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){ // 注意两个条件的先后顺序（短路策略）
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) break; // 快慢指针相遇
        }
        if(slow != fast) return null; // 无环时返回null，若能往下执行必有环
        fast = head; // 重复利用fast，放到表头处
        while(slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return slow; // return fast也可以
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(-1);
        head.next=new ListNode(-7);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next =  new ListNode(19);
        head.next.next.next.next.next =  new ListNode(6);
        head.next.next.next.next.next.next =  new ListNode(-9);
        head.next.next.next.next.next.next.next =  new ListNode(-5);
        head.next.next.next.next.next.next.next.next =  new ListNode(2);
        ListNode port = new ListNode(-5);
        head.next.next.next.next.next.next.next.next.next =  port;
        head.next.next.next.next.next.next.next.next.next.next =  port;
        Solution solution = new Solution();
        solution.detectCycle3(head);

    }

    public ListNode detectCycle3(ListNode head) {
        if(head.next==null||head==null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = slow.next;
        // 环中的节点
        ListNode cur = null;
        while(fast!=null){
            if(slow==fast){
                cur = slow;
                break;
            }
            slow = slow.next;
            fast = fast.next;
            if(fast.next!=null){
                fast = fast.next.next;
            }

        }
        System.out.println(cur.val);
        if(cur==null){
            return null;
        }
        int curCount = 1;
        ListNode tmp = cur.next;
        while(tmp!=cur){
            curCount++;
            tmp = tmp.next;
            //System.out.println(2);
        }
        System.out.println(curCount);
        slow = head;
        fast = head;
        while(curCount>0){
            fast = fast.next;
            curCount--;
        }
        System.out.println(fast.val);
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        System.out.println(slow.val);
        return slow;
    }
}