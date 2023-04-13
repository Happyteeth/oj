package 从上打印二叉树的层级遍历广度遍历;


import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public int[] levelOrder1(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Deque<TreeNode> queue = new ArrayDeque();
        List<Integer> list = new ArrayList();
        list.add(root.val);
        queue.offer(root);
        while (queue.size() > 0) {
            TreeNode tmp = queue.poll();
            if (tmp.left != null) {
                list.add(tmp.left.val);
                queue.offer(tmp.left);
            }
            if (tmp.right != null) {
                list.add(tmp.right.val);
                queue.offer(tmp.right);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null) {
            return result;
        }
        Deque<Deque<TreeNode>> queue = new ArrayDeque();
        queue.offer(new ArrayDeque<TreeNode>() {{
            add(root);
        }});
        result.add(new ArrayList<Integer>() {{
            add(root.val);
        }});
        int i = 1;
        while (queue.size() > 0) {
            i++;
            Deque<TreeNode> deque = queue.poll();
            Deque<TreeNode> levelQueue = new ArrayDeque();
            List<Integer> levelVal = new ArrayList();
            while (deque.size() > 0) {
                TreeNode tn = deque.poll();
                if (tn.left != null) {
                    levelVal.add(tn.left.val);
                    levelQueue.offer(tn.left);
                }
                if (tn.right != null) {
                    levelVal.add(tn.right.val);
                    levelQueue.offer(tn.right);
                }
            }
            if (levelQueue.size() > 0) {
                queue.add(levelQueue);
                result.add(levelVal);
            }
        }
        return result;
    }


    // TODO 优化版本
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new ArrayDeque();
        queue.offer(root);

        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> level = new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }

    /**
     * TODO 之字形打印
     * 请实现一个函数按照之字形顺序打印二叉树，
     * 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null) {
            return result;
        }
        Deque<Deque<TreeNode>> queue = new ArrayDeque();
        queue.offer(new ArrayDeque<TreeNode>() {{
            add(root);
        }});
        result.add(new ArrayList<Integer>() {{
            add(root.val);
        }});
        int i = 1;
        while (queue.size() > 0) {
            i++;
            Deque<TreeNode> deque = queue.poll();
            Deque<TreeNode> levelQueue = new ArrayDeque();
            List<Integer> levelVal = new ArrayList();
            while (deque.size() > 0) {
                // 偶数层，从右往左添加
                if(i%2==0){
                    // 画图，类比，取栈的pop
                    TreeNode tn = deque.pop();
                    if (tn.right != null) {
                        levelVal.add(tn.right.val);
                        levelQueue.push(tn.right);
                    }
                    if (tn.left != null) {
                        levelVal.add(tn.left.val);
                        levelQueue.push(tn.left);
                    }
                }
                else{
                    // 奇数层，从右往左添加
                    TreeNode tn = deque.pop();
                    if (tn.left != null) {
                        levelVal.add(tn.left.val);
                        levelQueue.push(tn.left);
                    }
                    if (tn.right != null) {
                        levelVal.add(tn.right.val);
                        levelQueue.push(tn.right);
                    }
                }
            }
            if (levelQueue.size() > 0) {
                queue.add(levelQueue);
                result.add(levelVal);
            }

        }
        return result;
    }

    // TODO 优化版本
    public List<List<Integer>> levelOrder4(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) deque.add(root);
        while(!deque.isEmpty()) {
            // 打印奇数层
            List<Integer> tmp = new ArrayList<>();
            for(int i = deque.size(); i > 0; i--) {
                // 从左向右打印
                TreeNode node = deque.removeFirst();
                // 关注打印上
                tmp.add(node.val);
                // 先左后右加入下层节点
                // 因为是从左向右打印，只能从左往右添加，不然从右向左打印会乱，
                // 只能在tmp 子节点上保证 是从右向左的，不能保证整一层是从右向左的
                // 保证奇数或偶数层的添加到deque上都是有序的
                if(node.left != null) deque.addLast(node.left);
                if(node.right != null) deque.addLast(node.right);
            }
            res.add(tmp);
            if(deque.isEmpty()) break; // 若为空则提前跳出
            // 打印偶数层
            tmp = new ArrayList<>();
            for(int i = deque.size(); i > 0; i--) {
                // 从右向左打印
                TreeNode node = deque.removeLast();
                tmp.add(node.val);
                // 先右后左加入下层节点
                if(node.right != null) deque.addFirst(node.right);
                if(node.left != null) deque.addFirst(node.left);
            }
            res.add(tmp);
        }
        return res;
    }
}