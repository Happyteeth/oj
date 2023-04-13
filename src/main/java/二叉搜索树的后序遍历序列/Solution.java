package 二叉搜索树的后序遍历序列;

public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length==0){
            return true;
        }
        if(postorder.length==1){
            return true;
        }
        return judge(postorder, 0, postorder.length-1);
       
    }
    public boolean judge(int[] postorder, int i, int j){
        // 一个节点（judge(postorder, i, newI-1) 可能导致i和j相等）或两个节点时
        if(j==i||j-i==1){
            return true;
        }
        if(j-i==2&&postorder[i]<postorder[j]&&postorder[j-1]>postorder[j]){
            return true;
        }
        int center = postorder[j];
        int newI = i;
        while(newI<j&&postorder[newI]<center){
            newI++;
        }
        for(int k=newI+1;k<j;k++){
            if(postorder[k]<center){
                return false;
            }
        }
        // 当全是右子树时，5，6，7，8
        if(newI==i){
            return judge(postorder, i, j-1);
        }else{
            // 注意 postorder[newI-1] 是右子树的一个节点
            return judge(postorder, i, newI-1)&&judge(postorder, newI, j);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.verifyPostorder(new int[]{4, 8, 6, 7});
    }
}