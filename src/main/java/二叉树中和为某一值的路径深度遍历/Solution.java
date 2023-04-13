package 二叉树中和为某一值的路径深度遍历;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    List<List<Integer>> result = new ArrayList();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        List<Integer> list = new ArrayList();
        search(root, target, list, 0);
        return result;
    }

    public void search(TreeNode root, int target, List<Integer> list, int sum) {
        list.add(root.val);
        if (root.left == null && root.right == null && root.val + sum == target) {
            // TODO new!!!!
            result.add(new ArrayList(list));
        }
        if (root.left != null) {
            search(root.left, target, list, sum + root.val);
        }
        if (root.right != null) {
            search(root.right, target, list, sum + root.val);
        }
        // TODO 剪枝
        list.remove(list.size() - 1);
    }
}