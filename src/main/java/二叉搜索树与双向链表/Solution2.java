package 二叉搜索树与双向链表;

class Solution2 {
    Node pre,head,head1;
    public Node treeToDoublyList(Node root) {
        if(root==null){
            return root;
        }

        dfs(root);
        head1.left = pre;
        pre.right = head1;
        return head1;
    }
    public void dfs(Node root){
        if(root==null){
            return;
        }
        dfs(root.left);
        head = root;
        head.left = pre;
        if(pre==null){
            head1=root;
        }else{
            pre.right=head;
        }
        pre = head;
        dfs(root.right);
    }
    // TODO 画图
    public void dfs1(Node root){
        if(root==null){
            return;
        }
        dfs(root.left);

        root.left = pre;
        if(pre==null){
            head1=root;
        }else{
            pre.right=root;
        }
        pre = root;
        dfs(root.right);
    }
}