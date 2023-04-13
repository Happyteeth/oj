package 二叉搜索树与双向链表;


import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

public class Solution {
    // TODO 笨方法
    List<Node> list = new ArrayList();
    public Node treeToDoublyList(Node root) {
        if(root==null){
            return root;
        }
        
        dfs(root);
        for(int i=0;i<list.size()-1;i++){
              Node pre = list.get(i);
              Node cur = list.get(i + 1);
              pre.right = cur;
              cur.left = pre;
        }
        Node head = list.get(0);
        Node tail = list.get(list.size()-1);
        head.left = tail;
        tail.right = head;
        return head;
    }
    public void dfs(Node root){
        if(root==null){
            return;
        }
        dfs(root.left);
        list.add(root);
        dfs(root.right);
    }

}