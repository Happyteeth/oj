package 重建二叉树;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 *
 *
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 *
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * }
 */
public class Solution {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int preorder[];
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return ConTree(preorder, 0, 0, inorder.length-1);
    }

    /**
     *
     * @param preorder
     * @param rootPreIdx 根节点在前序遍历中的下标
     * @param leftLevelInorderIdx 右子树树节点在中序遍历中的左边界（右子树需要计算确认） 根节点在中序遍历中的下标+1
     * @param rightLevelInorderIdx 左子树树节点在中序遍历中的右边界（左子树需要计算确认） 根节点在中序遍历中的下标-1
     * @return
     */
    public TreeNode ConTree(int[] preorder,int rootPreIdx, int leftLevelInorderIdx, int rightLevelInorderIdx){
        if(leftLevelInorderIdx > rightLevelInorderIdx) return null;
        // 根节点在中序遍历中的下标，用来判断边界下标
        int rootInoderIdx = map.get(preorder[rootPreIdx]);

        TreeNode  treeNode = new TreeNode(preorder[rootPreIdx]);
        treeNode.left = ConTree(preorder,rootPreIdx+1, leftLevelInorderIdx, rootInoderIdx-1);

        treeNode.right = ConTree(preorder,
                rootPreIdx+rootInoderIdx-leftLevelInorderIdx+1, rootInoderIdx+1, rightLevelInorderIdx);
        return treeNode;
    }

    //第一个参数就是二叉树中根节点在先序遍历中的索引下标(然后求出节点值,再利用节点值求出其在中序遍历中的索引下标,进而得出整个树),第二个参数是当前子树的左子树在中序遍历结果中的左边界(右边界需要根据根节点位置来动态判断),第三个参数与第二个参数相反(一个左边界一个右边界)
    //这里我们每一次递归时都可以明确的确定当前二叉树的根节点和左子树区间以及右子树区间.因为我们每次传进来的第一个参数都是当前子树的根节点
    TreeNode recur(int pre_root, int in_left, int in_right){
        //最后一个节点时左右边界重合即相等,所以大于时就证明已经遍历完二叉树了
        if(in_left > in_right) return null;
        //获取当前二叉树的根节点
        TreeNode root = new TreeNode(preorder[pre_root]);
        //获取在中序遍历结果中根节点所在索引,用来判断边界用
        int idx = map.get(preorder[pre_root]);
        //左子树的根的索引为先序中的根节点+1
        //递归左子树的左边界为原来的中序in_left
        //递归左子树的右边界为中序中的根节点索引-1
        root.left = recur(pre_root+1, in_left, idx-1);
        // TODO pre_root + (idx - in_left) + 1 pre_root 前序遍历数组中根节点的起始下标+    idx - in-left 中序遍历中根节点的下标-中序遍历左边界的下标（）=左子树的节点数
        //右子树的根的索引为先序中的当前根位置+左子树节点数+ 1
        //递归右子树的左边界为中序结果中当前根节点+1
        //递归右子树的右边界为中序结果中原来右子树的边界
        root.right = recur(pre_root + (idx - in_left) + 1, idx+1, in_right);
        return root;
    }

    TreeNode ConTree2(int preLeft, int preRight, int inLeft, int inRight){
        if(preLeft>preRight||inLeft>inRight) return null;

        int idx = map.get(preorder[preLeft]);
        TreeNode treeNode = new TreeNode(preorder[preLeft]);
        treeNode.left = ConTree2(preLeft+1, preLeft+idx-inLeft, inLeft, idx-1);
        treeNode.right = ConTree2(preLeft+idx-inLeft+1, preRight, idx+1, inRight);
        return treeNode;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;

        // 可以不做判断，因为题目中给出的数据都是有效的
        if (preLen != inLen) {
            return null;
        }

        this.preorder = preorder;

        // 以空间换时间，否则，找根结点在中序遍历中的位置需要遍历
        map = new HashMap(inLen);
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(0, preLen - 1, 0, inLen - 1);
    }

    /**
     * todo 看这个
     * 根据前序遍历数组的 [preL, preR] 和 中序遍历数组的 [inL, inR] 重新组建二叉树
     *
     * @param preL 前序遍历数组的区间左端点  //todo 有歧义 待修改
     * @param preR 前序遍历数组的区间右端点
     * @param inL  中序遍历数组的区间左端点
     * @param inR  中序遍历数组的区间右端点
     * @return 构建的新二叉树的根结点
     */
    private TreeNode buildTree(int preL, int preR,
                               int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }
        // 构建的新二叉树的根结点一定是前序遍历数组的第 1 个元素
        int pivot = preorder[preL];
        TreeNode root = new TreeNode(pivot);

        int pivotIndex = map.get(pivot);

        // 这一步得画草稿，计算边界的取值，必要时需要解方程，并不难
        // preL + (pivotIndex - inL)，  inL 中序遍历数组的区间左端点， (pivotIndex - inL) 指左子树的节点树
        // preL + (pivotIndex - inL)    preL 前序遍历数组的区间左端点  preL + (pivotIndex - inL) 指前序遍历数组的区间右端点
        // preL + (pivotIndex - inL) + 1 前序遍历中左子树右边界后的下一个值就是就是右子树的左边界值
        root.left = buildTree(preL + 1, preL + (pivotIndex - inL), inL, pivotIndex - 1);
        root.right = buildTree(preL + (pivotIndex - inL) + 1, preR, pivotIndex + 1, inR);
        return root;
    }


    /**
     * todo 看这个 参看上边注解
     * @param preCenter 前序遍历 （整个树或子树）根节点下标
     * @param preLeft
     * @param preRight
     * @param inLeft
     * @param inRight
     * @return
     */
    TreeNode ConTree3(int preCenter, int preLeft, int preRight, int inLeft, int inRight){
        if(preLeft>preRight||inLeft>inRight){
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[preCenter]);
        int inCenter = map.get(preorder[preCenter]);

        treeNode.left=ConTree3(preCenter+1, preCenter+1, preCenter+(inCenter-inLeft), inLeft, inCenter-1);
        treeNode.right=ConTree3(preCenter+(inCenter-inLeft)+1, preCenter+(inCenter-inLeft)+1, preRight, inCenter+1, inRight);
        return treeNode;
    }



    public static void main(String[] args) {
//        ReentrantLock
        Solution solution = new Solution();
        int preorder[] =
                {3,9,20,15,7};
        int inorder[] =
                {9,3,15,20,7};
      //  solution.buildTree(preorder, inorder);
        StringBuffer sb = new StringBuffer("123545467");
        sb.delete(0,1);
        System.out.println(sb.toString());
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}