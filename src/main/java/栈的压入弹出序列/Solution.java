package 栈的压入弹出序列;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Deque<Integer> stack = new ArrayDeque();
        int j=0;
        for(int i=0;i<pushed.length;i++){
            stack.push(pushed[i]);
            while(j<popped.length&&stack.size()>0&&stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.size()==0;
    }
}