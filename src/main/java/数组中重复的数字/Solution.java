package 数组中重复的数字;

import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 *
 * 限制：
 *
 * 2 <= n <= 100000
 */

public class Solution {
    public int findRepeatNumber(int[] nums) {
       new ArrayList<TreeNode>().stream().map(TreeNode::getChildCount).collect(Collectors.toList());

        for(int i=0;i<nums.length;i++){

                while(nums[i]!=i){
                    if((nums[i]==nums[nums[i]])){
                        return nums[i];
                    } else{
                        int tmp = nums[i];
                        int tmp1 = nums[nums[i]];
                        nums[i]=tmp1;
                        nums[tmp]=tmp;
                    }
                }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[]={2, 3, 1, 0, 2, 5, 3};
        System.out.println(solution.findRepeatNumber(nums));
    }
}