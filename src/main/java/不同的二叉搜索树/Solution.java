package 不同的二叉搜索树;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Solution {
    int total = 0;
    public int numTrees(int n) {

        for(int i=1;i<=n;i++){
            Set<Integer> set = new HashSet();
            set.add(i);
            TreeNode cur = new TreeNode();
            cur.val = i;
            f(set,n,cur);
        }
        return total;
    }
    public void f(Set<Integer> set,int length, TreeNode cur){
        if(set.size()==length){
            for(Integer i:set){
                System.out.print(i+" ");
            }
            System.out.println();
            total++;
            return;
        }
        if(cur.left!=null&&cur.right!=null){
            f(set,length,cur.left);
            f(set,length,cur.right);
        }
        for(int i=1;i<=length;i++){
            if(!set.contains(i)){
                if(i<cur.val&&cur.left==null){
                    set.add(i);
                    TreeNode left = new TreeNode();
                    left.val = i;
                    cur.left = left;
                    f(set,length,left);
                    set.remove(i);
                    cur.left=left;
                }
                if(i>cur.val&&cur.right==null){
                    set.add(i);
                    TreeNode right = new TreeNode();
                    right.val = i;
                    cur.right = right;
                    f(set,length,right);
                    set.remove(i);
                    cur.right=null;
                }
            }

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.numTrees(3);
    }
}
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
}