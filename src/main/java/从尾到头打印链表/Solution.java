package 从尾到头打印链表;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * 反转
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
            if(head==null){
                return new int[0];
            }
        ListNode begin = null;
        ListNode mid = head;
        ListNode next = head.next;
        int size = 0;
        while(mid!=null){
            size++;
            mid.next = begin;
            begin = mid;
            mid = next;
            if(next!=null) {

                next = next.next;
            }
        }
        int result[] = new int[size];
        int i=0;
        while(begin!=null){
            result[i] = begin.val;
            begin = begin.next;
            i++;
        }
        return result;
    }

    /**
     * 取数字反转，或存储到栈中
     * @param args
     * todo
     */

    /**
     * 遍历树，新建二叉树
     * @param args
     * todo
     */


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        Solution solution = new Solution();
        solution.reversePrint(listNode);
    }
}

  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }