package 二叉树的下一个结点;


import java.util.Stack;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        if(pNode.right!=null){
            TreeLinkNode node = pNode.right;
            while(node!=null&&node.left!=null){
                node = node.left;
            }
            return node;
        }
        else if(pNode.right==null){
            TreeLinkNode node = pNode.next;
            if(node!=null&&node.left!=null&&node.left.val==pNode.val){
                return node;
            }
            else if(node!=null){
                TreeLinkNode parNode;
                parNode=node.next;
                while(node!=null&&parNode!=null){
                    if(parNode!=null&&parNode.left!=null&&parNode.left.val==node.val){
                        return parNode;
                    }
                    node = parNode;
                    parNode = parNode.next;
                }
            }
        }
        return null;
    }
}
