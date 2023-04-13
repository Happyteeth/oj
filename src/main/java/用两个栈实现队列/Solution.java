package 用两个栈实现队列;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
    }
}
class CQueue {
    Stack<Integer> obj1,obj2;
    public CQueue() {
        obj1 = new Stack<Integer>();
        obj2 = new Stack<Integer>();
    }

    public void appendTail(int value) {
        obj1.push(value);
    }

    public int deleteHead() {
        if(obj2.isEmpty()){
            while(!obj1.isEmpty()){
                obj2.push(obj1.pop());
            }
            return obj2.isEmpty()?-1:obj2.pop();
        }else{
            return obj2.pop();
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */