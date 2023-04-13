package 树的子结构;

 class TreeNode {
     int val;
     TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 初始 树节点A 和 B 节点，和子节点判断是否相同时唯一的不同
       if(A==null||B==null){
           return false;
       }
        else {
            return isSame(A,B);
        }
    }
    boolean isSame(TreeNode A, TreeNode B){
         if(A==null&&B==null){
            return true;
        }
        else if(A==null&&B!=null){
            return false;
        }
        else if(A!=null&&B==null){
            return true;
        }
        else{
            // (B!=null&&A!=null) 情况
            if(A.val==B.val){
                boolean leftB = compareNode(A.left, B.left);
                boolean rightB = compareNode(A.right, B.right);
                // 当左右子树不相等，继续以A的左右节点为起点判断
               return (leftB&&rightB)||(isSame(A.left,B)||isSame(A.right,B));
            }else{
                return isSame(A.left,B)||isSame(A.right,B);
            }
        }
    }

    private boolean compareNode(TreeNode A, TreeNode B) {
        boolean b = false;
        if(B!=null){
            if(A!=null){
                b=(A.val==B.val)&&isSame(A,B);
            }else{
                b=false;
            }
        }else{
            b = true;
        }
        return b;
    }
}