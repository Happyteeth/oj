package 合并两个有序链表;

import java.util.HashSet;
import java.util.Set;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }

        ListNode newNode = null,head = null;
        ListNode n1 = list1;
        ListNode n2 = list2;
        while(n1!=null&&n2!=null){
        if(n1.val<n2.val){
            if(newNode==null){
                newNode = new ListNode(n1.val);
                head = newNode;
            }else{
                newNode.next = new ListNode(n1.val);
                newNode = newNode.next;
            }
            n1 = n1.next;
        }else{
            if(newNode==null){
                newNode = new ListNode(n2.val);
                head = newNode;
            }else{
                newNode.next = new ListNode(n2.val);
                newNode = newNode.next;
            }
            n2 = n2.next;
        }
        }
        while(n1!=null){
            newNode.next = new ListNode(n1.val);
            newNode = newNode.next;
            n1 = n1.next;
        }
        while(n2!=null){
            newNode.next = new ListNode(n2.val);
            newNode = newNode.next;
            n2 = n2.next;
        }
        return head;
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2){

        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode newNode;
        if(list1.val<list2.val){
            newNode = list1;
            list1 = list1.next;
        }else{
            newNode = list2;
            list2 = list2.next;
        }
        newNode.next = mergeTwoLists2(list1, list2);
        return newNode;
    }
    static Set<Character> set = new HashSet<Character>();
    public static void main(String[] args) {

    }
    {
        set.add('0');set.add('1');set.add('2');set.add('3');set.add('4');set.add('5');set.add('6');set.add('7');set.add('8');set.add('9');
    }
}